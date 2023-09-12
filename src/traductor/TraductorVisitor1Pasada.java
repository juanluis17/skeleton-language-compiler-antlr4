/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traductor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;
import parser.SkeletonLanguageBaseVisitor;
import parser.SkeletonLanguageLexer;
import parser.SkeletonLanguageParser;
import parser.SkeletonLanguageParser.ArgContext;
import ts.EnumType;
import ts.MethodSymbol;
import ts.NodoTreeParser;
import ts.SymbolTable;
import utilities.ByteCodeConstants;

/**
 *
 * @author juanluis Esta primera pasada es para insertar los métodos en la tabla
 * de símbolos
 */
public class TraductorVisitor1Pasada extends SkeletonLanguageBaseVisitor<NodoTreeParser<ST>> {

    private SymbolTable symbolTable;
    private HashSet<String> argsName;

    public TraductorVisitor1Pasada(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
        argsName = new HashSet();
    }

    public void compile(File source) {
        FileReader reader = null;
        try {
            reader = new FileReader(source);
            ANTLRInputStream input = new ANTLRInputStream(reader);
            SkeletonLanguageLexer lexer = new SkeletonLanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SkeletonLanguageParser parser = new SkeletonLanguageParser(tokens);
            ParseTree tree = parser.start();
            visit(tree);
        } catch (IOException ex) {
            throw new RuntimeException("Error de Entrada/Salida. Verifique que el fichero fuente exista.");
        }
    }

    @Override
    public NodoTreeParser<ST> visitStart(SkeletonLanguageParser.StartContext ctx) {
        //Visito nada más los métodos
        List<SkeletonLanguageParser.MethodsContext> methods = ctx.methods();
        for (SkeletonLanguageParser.MethodsContext method : methods) {
            visit(method);
        }
        //En este puneto ya se encuentran en la TS la información relacionada 
        //con los métodos
        //Se debe comprobar que el método por el cual se empieza la ejecución esté presente
        //Genero el nombre del método por el cual se debe comenzar la ejecución
        String name = ByteCodeConstants.generateMethodName(TraductorVisitor2Pasada.className, "skeleton", "");
        //Busco el símbolo en la tabla
        if (!symbolTable.exists(name)) {
            throw new RuntimeException("Error [" + ctx.start.getLine() + "] El método skeleton() no se ha declarado.");
        }
        return null;
    }

    /**
     * Se sobreescribe el método visitMethods con el objetivo de insertarlo en
     * la TS. Nótese que se deben sobreescribir otrs métodos como visitTipoInt,
     * visitTipoFloat, visitArg
     *
     * @param ctx
     * @return
     */
    @Override
    public NodoTreeParser<ST> visitMethods(SkeletonLanguageParser.MethodsContext ctx) {
        EnumType returnType = visit(ctx.tipoRet()).getType();
        //Obtengo el descriptor del tipo que retorna el método
        String returnTypeDescriptor = ByteCodeConstants.getDescriptor(returnType);
        String argDesc = "";
        //Se limpia el conjunto de nombre de los argumentos
        argsName.clear();
        if (ctx.arg() != null) {
            List<ArgContext> args = ctx.arg();
            for (ArgContext arg : args) {
                //Obtengo el tipo del nodo devuelto
                EnumType type = visit(arg).getType();
                //Obtengo el descriptor
                String desc = ByteCodeConstants.getDescriptor(type);
                //Concateno los descriptores
                argDesc += desc;
            }
        }
        // Obtener nombre del método
        String id = ctx.TK_ID().getText();
        //Generar nombre del método <NombreMetodo>_<LongitudNombreClase><NombreClase><TiposCodificados>
        String name = ByteCodeConstants.generateMethodName(TraductorVisitor2Pasada.className, id, argDesc);
        //Se busca en la tabla de símbolos si ya se ha declarado un símbolo con este identificador
        if (symbolTable.exists(name)) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Identificador de método declarado previamente.");
        }
        //El método no existe lo inserto en la tabla
        MethodSymbol method = new MethodSymbol(id, returnTypeDescriptor, returnType, argDesc, name, ctx.TK_ID().getSymbol().getLine());
        symbolTable.insert(method);
        //Devuelvo un nodo con el valor null
        return new NodoTreeParser(null);
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
        //Se busca si ya se declarado un argumento con este nombre
        if (argsName.contains(id)) {
            throw new RuntimeException("Error [" + ctx.TK_ID().getSymbol().getLine() + "] Ya se ha declarado un argumento con ese nombre.");
        }
        argsName.add(id);
        //Obtener el tipo
        NodoTreeParser<ST> var = visit(ctx.tipo());
        EnumType type = var.getType();
        //Retorno con un nodo con el tipo, el nombre de la variable en esta pasada no es de interés
        return new NodoTreeParser(type);
    }

    @Override
    public NodoTreeParser<ST> visitTipoInt(SkeletonLanguageParser.TipoIntContext ctx) {
        return new NodoTreeParser(EnumType.INT);
    }

    @Override
    public NodoTreeParser<ST> visitTipoFloat(SkeletonLanguageParser.TipoFloatContext ctx) {
        return new NodoTreeParser(EnumType.FLOAT);
    }
}
