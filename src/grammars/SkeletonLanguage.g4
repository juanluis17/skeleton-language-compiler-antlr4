            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar SkeletonLanguage;

start       :
                attributes* methods+
            ;

attributes  :
                tipo TK_ID ';'  
            ;
//El método por el que se empieza la ejecución se llama void skeleton()
methods     :   
                tipoRet TK_ID '(' (arg (',' arg)*)?')' '{'sent*'}' 
            ;

tipoRet     :   TK_VOID
                |tipo
            ;

arg         :   
                tipo TK_ID
            ;

sent        :
                block
                |sentAsig
                |sentSalida
                |sentIf
                |sentReturn
                |localDclVar 
                |callMethodSent
            ;

sentAsig    :
                TK_ID '=' exp ';'
            ;

sentSalida  :
                (TK_PRINT|TK_PRINTLN) '('exp(',' exp)*')' ';'
            ;

sentIf      :   
                TK_IF '('exp')' sent (TK_ELSE sent)?
            ;

sentReturn  :   
                TK_RETURN exp? ';'
            ;

localDclVar :
                tipo TK_ID ('=' exp)? ';'
            ;

block       :   
                '{' sent* '}'
            ;

callMethod  :
                TK_ID '(' (exp (',' exp)*)? ')'
            ;

callMethodSent: callMethod ';'
              ;


exp         :    
                callMethod                                  #ExpCallMethod        
                |exp op=('*'|'/') exp                       #ExpMulDiv
                |exp op=('+'|'-') exp                       #ExpAddSub
                |'(' exp ')'                                #ExpParent
                |cte                                        #ExpCte
                |TK_ID                                      #ExpID
            ;

cte         :
                TK_CTE_INT                                  #CteInt
                |TK_CTE_FLOAT                               #CteFloat
            ;

tipo        :   TK_TIPO_INT                                 #TipoInt
                |TK_TIPO_FLOAT                              #TipoFloat
            ;
                
//Lexer
//Palabras reservadas
TK_PRINT    :  'PRINT' | 'print'
            ;
TK_PRINTLN  :  'PRINTLN' | 'println'
            ;
TK_READ     :  'READ' | 'read'
            ;
TK_TIPO_INT :  'INT' | 'int'
            ;
TK_TIPO_FLOAT: 'FLOAT' | 'float'
            ;
TK_VOID     :   'void' | 'VOID'
            ;
TK_IF       :  'IF' | 'if'
            ;
TK_ELSE     :  'ELSE' | 'else'
            ;
TK_RETURN   :  'RETURN' | 'return'
            ;
//Operadores
MUL         :   '*' ;
DIV         :   '/' ;
ADD         :   '+' ;
SUB         :   '-' ;
SIGNO       :   (ADD)|(SUB);
//Constantes
TK_CTE_INT  :  (SIGNO)?DIGITO+
            ;
TK_CTE_FLOAT:  (TK_CTE_INT)'.'DIGITO+
            ;
TK_ID       :  ('_'|LETRA)('_'|LETRA|DIGITO)*
            ;
fragment
LETRA       :  ('a'..'z'|'A'..'Z')
            ;
fragment
DIGITO      :  '0'..'9'
            ;
WS          :
                (' '
                |'\t'
                |'\r'
                |'\n'
                )
                {skip();}
            ;