/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ts;

/**
 *
 * @author juanluis
 */
public class GlobalVarSymbol extends VarSymbol {
    
    //Aquí pudierasn ir los modificadores u otro elementos de las variables globales

    public GlobalVarSymbol(EnumType type, boolean initialized, String name, int line) {
        super(type, initialized, name, line);
    }

    @Override
    public int getSymbolType() {
        return Symbol.GLOBAL_VAR;
    }
}
