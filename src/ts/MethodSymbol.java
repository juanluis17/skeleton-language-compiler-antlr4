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
public class MethodSymbol extends Symbol {
    
    //Nombre real del método, esto se debe a que en la TS se inserta con un nombre compuesto
    //Este nombre real se utiliza para la plantilla
    protected String realName;
    //Tipo de retorno //Descriptor
    protected String returnTypeDescriptor;
    //Tipo de retorno EnumType
    protected EnumType returnType;
    //Tipo parámetros //Descriptor
    protected String argDesc;

    public MethodSymbol(String realName, String returnTypeDescriptor, EnumType returnType, String argDesc, String name, int line) {
        super(name, line);
        this.realName = realName;
        this.returnTypeDescriptor = returnTypeDescriptor;
        this.returnType = returnType;
        this.argDesc = argDesc;
    }


   
    
      @Override
    public int getSymbolType() {
       return Symbol.METHOD;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getReturnTypeDescriptor() {
        return returnTypeDescriptor;
    }

    public void setReturnTypeDescriptor(String returnTypeDescriptor) {
        this.returnTypeDescriptor = returnTypeDescriptor;
    }

    public EnumType getReturnType() {
        return returnType;
    }

    public void setReturnType(EnumType returnType) {
        this.returnType = returnType;
    }

    public String getArgDesc() {
        return argDesc;
    }

    public void setArgDesc(String argDesc) {
        this.argDesc = argDesc;
    }

}
