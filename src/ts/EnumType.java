package ts;

public enum EnumType {
    
    PALABRA_RESERVADA("pr"),INT("i"),FLOAT("f"),STRING("s"),VOID("v"),NIL("n");
	private final String value;
	private EnumType(String value){
	    this.value= value;
	}
	public String value(){
	    return value;
	}
	
}