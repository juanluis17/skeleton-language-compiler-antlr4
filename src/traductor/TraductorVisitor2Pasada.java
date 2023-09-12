/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductor;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;
import parser.SkeletonLanguageParser;
import parser.SkeletonLanguageBaseVisitor;
import parser.SkeletonLanguageLexer;
import parser.SkeletonLanguageParser.ArgContext;
import parser.SkeletonLanguageParser.ExpContext;
import parser.SkeletonLanguageParser.SentContext;
import ts.*;
import utilities.ByteCodeConstants;
import static utilities.ByteCodeConstants.generateMethodName;

/**
 *
 * @author juanluis
 */
public class TraductorVisitor2Pasada extends SkeletonLanguageBaseVisitor<NodoTreeParser<ST>> {

    //Grupo de plantillas
    private STGroup bytecode;
    //Manejo de los símbolos y sus ámbitos de ejecución, podemos tener una variab
    private Stack<SymbolTable> environment;
    //Fichero que contiene el código fuente a compilar
    private File source;
    //Variable para asignar el número a cada variable local
    private int locals;
    //Variable para las etiquetas
    private int labels;
    //Tipo de dato que retorna la función actual
    private String returnTypeActual;
    //Indica si se ha insertado una función return
    private boolean returnActive;
    //Nombre de la clase en Java
    public static final String className = "SkeletonLanguage";

    public TraductorVisitor2Pasada() {
        bytecode = new STGroupFile("src/templates/ByteCode.stg");
        environment = new Stack<>();
        locals = -1;
        labels = 0;
    }

    public void compile(File source) {
        try {
            this.source = source;
            FileReader reader = new FileReader(source);
            ANTLRInputStream input = new ANTLRInputStream(reader);
            SkeletonLanguageLexer lexer = new SkeletonLanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SkeletonLanguageParser parser = new SkeletonLanguageParser(tokens);
            ParseTree tree = parser.start();
            visit(tree);
            System.out.println("Código compilado exitosamente");
        } catch (IOException ex) {
            throw new RuntimeException("Error de Entrada/Salida. Verifique que el fichero fuente exista.");
        }
    }

    @Override
    public NodoTreeParser<ST> visitStart(SkeletonLanguageParser.StartContext ctx) {
        //Se crea una tabla de símbolos (TS) para el contexto global, es decir, los atributos y métodos
        SymbolTable table = new SymbolTable();
        //Aquí se llama a la primera pasada para que llene la tabla creada arriba con la información de los métodos
        //En el caso de las variables globales no es necesario.
        TraductorVisitor1Pasada _1Pasada = new TraductorVisitor1Pasada(table); //Se llena la tabla con los símbolos correspondientes a los métodos
        _1Pasada.compile(source);
        //Una vez llenada la tabla con los métodos, se añade a la pila de ámbitos de ejecución
        environment.push(table);
        //Se llama a la plantilla javaClass, es una modificación de jasminFile
        ST tag = bytecode.getInstanceOf("javaClass");
        tag.add("className", className);
        List<SkeletonLanguageParser.AttributesContext> attributes = ctx.attributes();
        for (SkeletonLanguageParser.AttributesContext att : attributes) {
            tag.add("attributes", visit(att).getValue());
        }
        List<SkeletonLanguageParser.MethodsContext> methods = ctx.methods();
        for (SkeletonLanguageParser.MethodsContext method : methods) {
            tag.add("methods", visit(method).getValue());
        }
        //Se elimina la TS del contexto global de la pila.
        environment.pop();
        try {
            //Se escribe el .j
            FileWriter writer = new FileWriter(className + ".j");
            writer.write(tag.render());
            writer.close();
        } catch (IOException ex) {
            throw new RuntimeException("Error de Entrada/Salida. No se pudo escribir el código generado hacia un fichero.");
        }
        return null;
    }

    @Override
    public NodoTreeParser<ST> visitAttributes(SkeletonLanguageParser.AttributesContext ctx) {
        // Obtener nombre del identificador
        String id = ctx.TK_ID().getText();
        //Se busca en la pila si ya se ha declarado un símbolo con este identificador
        //La función searchSymbol busca en los diferentes ámbitos de ejecución de la pila
        if (searchSymbol(id) != null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador declarado previamente.");
        }
        // Obtener el tipo
        NodoTreeParser<ST> var = visit(ctx.tipo());
        EnumType type = var.getType();
        GlobalVarSymbol symbol = new GlobalVarSymbol(type, false, id, ctx.TK_ID().getSymbol().getLine());
        //Se inserta el símbolo dentro del ámbito que se encuentra en el tope de la pila
        environment.peek().insert(symbol);
        //Llenar plantilla asociada a atributo
        ST tag = bytecode.getInstanceOf("attribute");
        tag.add("name", symbol.getName());
        tag.add("type", ByteCodeConstants.getDescriptor(symbol.getType()));
        return new NodoTreeParser(tag);
    }

    @Override
    public NodoTreeParser<ST> visitMethods(SkeletonLanguageParser.MethodsContext ctx) {
        //Se reinicia la variable locals en 0
        locals = 0;
        //Se coloca returnActive en falso
        returnActive = false;
        //Se crea una tabla de símbolos (TS) para el contexto relacionado con el método
        SymbolTable table = new SymbolTable();
        //Se añade a la pila de ámbitos de ejecución
        environment.push(table);
        //Se obtiene una instancia de la plantilla a llenar
        ST tag = bytecode.getInstanceOf("method");
        //Tipo de retorno
        EnumType typeReturn = visit(ctx.tipoRet()).getType();
        returnTypeActual = ByteCodeConstants.getDescriptor(typeReturn);
        //Se añade el descriptor de retorno a la plantilla
        tag.add("retDesc", returnTypeActual);
        //Descriptores de los argumentos
        String argDesc = "";
        if (ctx.arg() != null) {
            List<ArgContext> args = ctx.arg();
            for (ArgContext arg : args) {
                EnumType type = visit(arg).getType();
                String desc = ByteCodeConstants.getDescriptor(type);
                argDesc += desc;
            }
        }
        //Se añade a la plantilla los descriptores de los argumentos
        tag.add("argDesc", argDesc);
        //Obtener nombre del método
        String id = ctx.TK_ID().getText();
        //No es necesario generar el nombre del método pq no se va a realizar una búsqueda en la TS, ya estos métodos se encuentran en la TS.
        //No es necesario insertar la información asociada al método en la TS porque ya se hizo en la primera pasada
        //Añado el nombre real (no el generado) del método a la plantilla
        tag.add("name", id);
        //Se visitan las sentencias
        //Notese qie la celcaración de una variable local es una sentencia.
        List<SentContext> sents = ctx.sent();
//        if (sents.isEmpty()) {
//        } else {
        for (SentContext sent : sents) {
            if (returnActive) {
                //Ya la sentencia anterior es de tipo return, por lo que si existe otra después se retorna un error.
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] La sentencia return debe ser la última del método.");
            }
            //Se obtiene la plantilla asociada a la sentencia
            NodoTreeParser<ST> nodo = visit(sent);
            ST aux = nodo.getValue();
            //Se pregunta si es diferente de null, esto se debe a que cdo se declara una variable local y no se incializa, no se genera ningún código
            if (aux != null) {
                //Se añade el código asociado a la sentencia a la plantilla del método
                tag.add("instructions", aux);
            }
//            }
        }
        //Pregunto si no existe una sentencia return
        if (!returnActive) {
            //Si no existe pregunto si lo que devuelve la función es VOID
            if (returnTypeActual.equals(ByteCodeConstants.getDescriptor(EnumType.VOID))) {
                //Si es void añado el return
                tag.add("instructions", "return");
            } else {
                //Si no es void entonces ERROR
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Falta la sentencia return en el método.");
            }
        }
        tag.add("maxStackDepth", 3);
        tag.add("maxLocals", environment.peek().symbolsQuantity() + 1);
        environment.pop();
        return new NodoTreeParser(tag);
    }

    @Override
    public NodoTreeParser<ST> visitTipoRet(SkeletonLanguageParser.TipoRetContext ctx) {
        if (ctx.tipo() != null) {
            return visit(ctx.tipo());
        } else {
            return new NodoTreeParser<>(EnumType.VOID);
        }
    }

    @Override
    public NodoTreeParser<ST> visitArg(ArgContext ctx) {
        //Obtener nombre del identificador
        String id = ctx.TK_ID().getText();
        //Se busca en la pila si ya se ha declarado un símbolo con este identificador.
        //Este símbolo puede ser una variable global e incluso un argumento declarado anteriormente, por ejemplo main(int a, int a)
        //En otros lenguajes como Java, el nombre del argumento puede ser igual al de un atributo de la clase, en este caso debe modificarse 
        //el método searchSymbol
        if (searchSymbol(id) != null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador declarado previamente.");
        }
        //Obtener el tipo
        NodoTreeParser<ST> var = visit(ctx.tipo());
        EnumType type = var.getType();
        //Creo la variable local que representa el argumento, pongo en inicializad true, porque esta variable se incializa con 
        //los parñametro que se coloquen en la llamada al método
        LocalVarSymbol symbol = new LocalVarSymbol(locals++, type, true, id, ctx.TK_ID().getSymbol().getLine());
        //Se inserta el símbolo dentro del ámbito que se encuentra en el tope de la pila
        environment.peek().insert(symbol);
        //No se genera ningún código, solo se inserta el símbolo en la TS que se encuentra en el tope de la pila
        return new NodoTreeParser(type);
    }

    @Override
    public NodoTreeParser<ST> visitCallMethodSent(SkeletonLanguageParser.CallMethodSentContext ctx) {
        return visit(ctx.callMethod());
    }

    @Override
    public NodoTreeParser<ST> visitSentAsig(SkeletonLanguageParser.SentAsigContext ctx) {
        //Obtener nombre del identificador
        String id = ctx.TK_ID().getText();
        //Se busca en la pila si ya se ha declarado un símbolo con este identificador
        //Además el símbolo debe ser de tipo LOCAL_VAR o GLOBAL_VAR
        Symbol symbol = searchSymbol(id);
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador de variable no declarado previamente.");
        } else if (symbol.getSymbolType() != Symbol.LOCAL_VAR && symbol.getSymbolType() != Symbol.GLOBAL_VAR) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El identificador debe ser una variable.");
        }
        //Visito la expresión
        NodoTreeParser<ST> exp = visit(ctx.exp());
        //Obtengo el tipo
        EnumType type = ((VarSymbol) symbol).getType();
        String convTipo = "";
        switch (type) {
            case INT:
                if (type != exp.getType()) {
                    throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
                }
                break;
            case FLOAT:
                if (type != exp.getType()) {
                    //Como solo existen dos tipos se pregunta si son diferentes, es decir, 
                    //si type es FLOAT y es diferente a exp.getType, entonces este último es de tipo INT
                    //Esto debe cambiarse para tratar otros tipos
                    convTipo = "i2f";
                }
                break;
        }
        ST tag = null;
        if (symbol.getSymbolType() == Symbol.LOCAL_VAR) {
            //El símbolo es una variable local, se llena la platilla para variables locales
            tag = bytecode.getInstanceOf("assignLocal");
            tag.add("varNum", ((LocalVarSymbol) symbol).getNum());
            tag.add("mnemonic", ByteCodeConstants.getMnemonic(type));
        } else if (symbol.getSymbolType() == Symbol.GLOBAL_VAR) {
            //Es una variable global, se llena la plantilla para variables globales
            tag = bytecode.getInstanceOf("assignGlobal");
            tag.add("className", className);
            tag.add("descriptor", ByteCodeConstants.getDescriptor(type));
        }
        tag.add("v", exp.getValue());
        if (!convTipo.equals("")) {
            //Se genera la instrucción de conversión de tipo
            tag.add("v", convTipo);
        }
        //Se llena con el nombre de la variable
        tag.add("id", id);
        return new NodoTreeParser(tag);
    }

    @Override
    public NodoTreeParser<ST> visitSentSalida(SkeletonLanguageParser.SentSalidaContext ctx) {
        List<SkeletonLanguageParser.ExpContext> lista = ctx.exp();
        String ln = (ctx.TK_PRINTLN() != null) ? "ln" : "";
        ST block = bytecode.getInstanceOf("block");
        for (SkeletonLanguageParser.ExpContext exp : lista) {
            NodoTreeParser<ST> nodo = visit(exp);
            ST tag = null;
            switch (nodo.getType()) {
                case INT:
                    tag = bytecode.getInstanceOf("iwrite");
                    break;
                case FLOAT:
                    tag = bytecode.getInstanceOf("fwrite");
                    break;
            }
            tag.add("v", nodo.getValue());
            tag.add("ln", ln);
            block.add("instructions", tag);
        }
        return new NodoTreeParser(block);
    }

    @Override
    public NodoTreeParser<ST> visitSentIf(SkeletonLanguageParser.SentIfContext ctx) {
        //Primero se debe generar la comparación
        //La compración debe ser exp con 0
        NodoTreeParser<ST> exp = visit(ctx.exp());
        if (exp.getType() != EnumType.INT) {
            throw new RuntimeException("Error [" + ctx.TK_IF().getSymbol().getLine() + "] La expresión debe ser de tipo entera.");
        }
        //cmp recibe la plantilla que tiene exp, recuerden que con los enteros se puede preguntar directamente.
        ST cmp = exp.getValue();
        //Se comienza a llenar la plantilla del if
        ST _if = bytecode.getInstanceOf("if");
        //Añadir la expresión de comparación
        _if.add("exp", cmp);
        //Añadir la etiqueta 1
        _if.add("label1", labels++);
        //Visitar la sent del IF
        NodoTreeParser<ST> sent1 = visit(ctx.sent(0));
        //Añadir la plantilla de la sent a la platilla del IF
        _if.add("sent1", sent1.getValue());
        //Verificar si existe la sentencia del else
        if (ctx.TK_ELSE() != null) {
            //Si existe se visita
            NodoTreeParser<ST> sent2 = visit(ctx.sent(1));
            //Añadir la etiqueta 2
            _if.add("label2", labels++);
            //Añadir la sentencia del else
            _if.add("sent2", sent2.getValue());
        }
        //Se retorna la plantilla del if
        return new NodoTreeParser<ST>(_if);
    }

    @Override
    public NodoTreeParser<ST> visitSentReturn(SkeletonLanguageParser.SentReturnContext ctx) {
        NodoTreeParser<ST> exp = visit(ctx.exp());
        ST tag = bytecode.getInstanceOf("return");
        String tipoExp = ByteCodeConstants.VOID_TYPE_DESC; //Incicializo con void
        if (exp != null) {
            //Si existe una expresión, se llenan los huecos v y mnemonic
            tag.add("v", exp.getValue());
            tag.add("mnemonic", ByteCodeConstants.getMnemonic(exp.getType()));
            tipoExp = ByteCodeConstants.getDescriptor(exp.getType());
        }
        //Void
        //Se chequea que el tipo de retorno del método coincida con el tipo de la expresión exp
        if (!returnTypeActual.equals(tipoExp)) {
            throw new RuntimeException("Error [" + ctx.TK_RETURN().getSymbol().getLine() + "] El tipo devuelto no coincide con el declarado.");
        }
        //Se coloca return como activo
        returnActive = true;
        return new NodoTreeParser(tag);
    }

    @Override
    public NodoTreeParser<ST> visitCallMethod(SkeletonLanguageParser.CallMethodContext ctx) {
        //Nombre del método
        String name = ctx.TK_ID().getText();
        //Obtengo la plantilla
        ST tag = bytecode.getInstanceOf("callMethod");
        //Obtengo el tipo de los argumentos
        String argDesc = "";
        List<ExpContext> exps = ctx.exp();
        for (ExpContext exp : exps) {
            NodoTreeParser<ST> aux = visit(exp);
            //Añado el cñodigo que genera expresión
            tag.add("v", aux.getValue());
            //Concateno los descriptores
            argDesc += ByteCodeConstants.getDescriptor(aux.getType());
        }
        String nameGenerate = generateMethodName(className, name, argDesc);
        Symbol symbol = searchSymbol(nameGenerate);
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El método no se ha declarado previamente.");
        } else if (symbol.getSymbolType() != Symbol.METHOD) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] El identificador no se corresponde con un método.");
        }
        tag.add("className", className);
        //Nombre real
        tag.add("id", ((MethodSymbol) symbol).getRealName());
        tag.add("argDesc", argDesc);
        tag.add("retDesc", ((MethodSymbol) symbol).getReturnTypeDescriptor());
        return new NodoTreeParser<>(((MethodSymbol) symbol).getReturnType(), tag);
    }

    @Override
    public NodoTreeParser<ST> visitLocalDclVar(SkeletonLanguageParser.LocalDclVarContext ctx) {
        // Obtener nombre del identificador
        String id = ctx.TK_ID().getText();
        //Se busca en la pila si ya se ha declarado un símbolo con este identificador
        if (searchSymbol(id) != null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador declarado previamente.");
        }
        //Obtener el tipo
        EnumType type = visit(ctx.tipo()).getType();
        boolean initialized = false;
        int num = locals++;
        ST tag = null;
        if (ctx.exp() != null) {
            initialized = true;
            NodoTreeParser<ST> exp = visit(ctx.exp());
            if (type == EnumType.INT && exp.getType() == EnumType.FLOAT) {
                throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Asignación de tipos incompatibles.");
            }
            tag = bytecode.getInstanceOf("assignLocal");
            tag.add("varNum", num);
            tag.add("mnemonic", ByteCodeConstants.getMnemonic(type));
            tag.add("v", exp.getValue());
            tag.add("id", id);
        }
        //Creo el símbolo
        LocalVarSymbol symbol = new LocalVarSymbol(num, type, initialized, id, ctx.TK_ID().getSymbol().getLine());
        //Lo inserto en la TS
        environment.peek().insert(symbol);
        return new NodoTreeParser(tag);
    }

    @Override
    public NodoTreeParser<ST> visitBlock(SkeletonLanguageParser.BlockContext ctx) {
        ST tag = null;
        if (ctx.sent() != null) {
            //Se crea una tabla de símbolos (TS) para el contexto relacionado con el bloque
            SymbolTable table = new SymbolTable();
            //Se añade a la pila de ámbitos de ejecución
            environment.push(table);
            List<SkeletonLanguageParser.SentContext> lista = ctx.sent();
            tag = bytecode.getInstanceOf("block");
            for (SkeletonLanguageParser.SentContext sent : lista) {
                ST value = visit(sent).getValue();
                tag.add("instructions", value);
            }
            //Se elimina el ámbito de ejecución
            environment.pop();
        }
        return new NodoTreeParser(tag);
    }

    @Override
    public NodoTreeParser<ST> visitExpCallMethod(SkeletonLanguageParser.ExpCallMethodContext ctx) {
        return visit(ctx.callMethod());
    }

    @Override
    public NodoTreeParser<ST> visitExpMulDiv(SkeletonLanguageParser.ExpMulDivContext ctx) {
        NodoTreeParser<ST> nLeft = visit(ctx.exp(0));  // Obtener tipo exp izq
        NodoTreeParser<ST> nRight = visit(ctx.exp(1)); // Obtener tipo exp derecha
        NodoTreeParser<ST> rpta = new NodoTreeParser(null);
        ST tag = null;
        String sufijo = (ctx.op.getText().equals("*")) ? "mult" : "div";
        String mnemonic = "";
        tag = bytecode.getInstanceOf(sufijo);
        if (nLeft.getType() == EnumType.FLOAT || nRight.getType() == EnumType.FLOAT) {
            mnemonic = ByteCodeConstants.FLOAT_TYPE_NEM;
            tag.add("a", nLeft.getValue());
            if (nLeft.getType() == EnumType.INT) {
                tag.add("a", "i2f");
            }
            tag.add("b", nRight.getValue());
            if (nRight.getType() == EnumType.INT) {
                tag.add("b", "i2f");
            }
            rpta.setType(EnumType.FLOAT);
        } else {
            tag.add("a", nLeft.getValue());
            tag.add("b", nRight.getValue());
            rpta.setType(EnumType.INT);
        }
        tag.add("mnemonic", mnemonic);
        rpta.setValue(tag);
        return rpta;
    }

    @Override
    public NodoTreeParser<ST> visitExpAddSub(SkeletonLanguageParser.ExpAddSubContext ctx) {
        NodoTreeParser<ST> nLeft = visit(ctx.exp(0));  // Obtener tipo exp izq
        NodoTreeParser<ST> nRight = visit(ctx.exp(1)); // Obtener tipo exp derecha
        NodoTreeParser<ST> rpta = new NodoTreeParser(null);
        ST tag = null;
        String sufijo = (ctx.op.getText().equals("+")) ? "add" : "sub";
        String mnemonic = "";
        tag = bytecode.getInstanceOf(sufijo);
        if (nLeft.getType() == EnumType.FLOAT || nRight.getType() == EnumType.FLOAT) {
            mnemonic = ByteCodeConstants.FLOAT_TYPE_NEM;
            tag.add("a", nLeft.getValue());
            if (nLeft.getType() == EnumType.INT) {
                tag.add("a", "i2f");
            }
            tag.add("b", nRight.getValue());
            if (nRight.getType() == EnumType.INT) {
                tag.add("b", "i2f");
            }
            rpta.setType(EnumType.FLOAT);
        } else {
            mnemonic = ByteCodeConstants.INT_TYPE_NEM;
            tag.add("a", nLeft.getValue());
            tag.add("b", nRight.getValue());
            rpta.setType(EnumType.INT);
        }
        tag.add("mnemonic", mnemonic);
        rpta.setValue(tag);
        return rpta;
    }

    @Override
    public NodoTreeParser<ST> visitExpID(SkeletonLanguageParser.ExpIDContext ctx) {
        String id = ctx.TK_ID().getText();
        Symbol symbol = searchSymbol(id);
        if (symbol == null) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador no declarado.");
        }
        ST tag = null;
        EnumType type = null;
        if (symbol.getSymbolType() == Symbol.LOCAL_VAR) {
            type = ((LocalVarSymbol) symbol).getType();
            tag = bytecode.getInstanceOf("loadLocal");
            tag.add("varNum", ((LocalVarSymbol) symbol).getNum());
            tag.add("mnemonic", ByteCodeConstants.getMnemonic(type));
        } else if (symbol.getSymbolType() == Symbol.GLOBAL_VAR) {
            type = ((GlobalVarSymbol) symbol).getType();
            tag = bytecode.getInstanceOf("loadGlobal");
            tag.add("className", className);
            tag.add("descriptor", ByteCodeConstants.getDescriptor(type));
        }
        tag.add("id", id);
        return new NodoTreeParser(type, tag);
    }

    @Override
    public NodoTreeParser<ST> visitExpCte(SkeletonLanguageParser.ExpCteContext ctx) {
        return visit(ctx.cte());
    }

    @Override
    public NodoTreeParser<ST> visitExpParent(SkeletonLanguageParser.ExpParentContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public NodoTreeParser<ST> visitCteInt(SkeletonLanguageParser.CteIntContext ctx) {
        NodoTreeParser<ST> aux = new NodoTreeParser(EnumType.INT);
        ST tag = bytecode.getInstanceOf("const");
        tag.add("v", Integer.parseInt(ctx.TK_CTE_INT().getText()));
        aux.setValue(tag);
        return aux;
    }

    @Override
    public NodoTreeParser<ST> visitCteFloat(SkeletonLanguageParser.CteFloatContext ctx) {
        NodoTreeParser<ST> aux = new NodoTreeParser(EnumType.FLOAT);
        ST tag = bytecode.getInstanceOf("const");
        tag.add("v", Float.parseFloat(ctx.TK_CTE_FLOAT().getText()));
        aux.setValue(tag);
        return aux;
    }

    @Override
    public NodoTreeParser<ST> visitTipoInt(SkeletonLanguageParser.TipoIntContext ctx) {
        return new NodoTreeParser(EnumType.INT);
    }

    @Override
    public NodoTreeParser<ST> visitTipoFloat(SkeletonLanguageParser.TipoFloatContext ctx) {
        return new NodoTreeParser(EnumType.FLOAT);
    }

    /**
     * Devuelve true si existe un símbolo con igual nombre definido en alguna TS
     * de los diferentes ámbitos de ejecución
     *
     * @param name Nombre del símbolo
     * @return true si existe, false en caso contrario
     */
    private Symbol searchSymbol(String name) {
        int size = environment.size();
        for (int i = size - 1; i >= 0; i--) {
            SymbolTable table = environment.get(i);
            Symbol symbol = table.search(name);
            if (symbol != null) {
                return symbol;
            }
        }
        return null;
    }

}
