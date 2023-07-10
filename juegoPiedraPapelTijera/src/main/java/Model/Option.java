package Model;

import lombok.Data;

@Data
public class Option {

	protected String name = "";
	protected String action = "";
	protected String simbolo = "";
	
	
	
	public Option (String name,String action, String simbolo){
		super();
		
		this.name = name;
		this.action = action;
		this.simbolo = simbolo;
		
	}
	
	
}
