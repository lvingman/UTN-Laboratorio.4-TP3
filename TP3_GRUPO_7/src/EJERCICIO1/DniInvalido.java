package EJERCICIO1;

import java.io.IOException;

public class DniInvalido extends IOException {

	public DniInvalido() {
		
	}
	
	@Override
	public String getMessage() {
		return "El DNI no es valido";
	}
	
	
}
