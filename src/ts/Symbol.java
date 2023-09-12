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
public abstract class Symbol {

   
    protected String name;
    protected int line;

    public Symbol(String name, int line) {
        this.name = name;
        this.line = line;
    }

    public abstract int getSymbolType(); 
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public static final int GLOBAL_VAR = 0;
    public static final int LOCAL_VAR = 1;
    public static final int METHOD = 2;

}
