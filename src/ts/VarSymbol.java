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
public abstract class VarSymbol extends Symbol {
    
    protected EnumType type;
    protected boolean initialized;

    public VarSymbol(EnumType type, boolean initialized, String name, int line) {
        super(name, line);
        this.type = type;
        this.initialized = initialized;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }
    
   
}
