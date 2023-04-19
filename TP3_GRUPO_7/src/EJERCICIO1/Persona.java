package EJERCICIO1;


public class Persona implements Comparable<Persona>{

	private String nombre;
	private String apellido;
	private String dni;
	
	public Persona() {}

	
	public Persona(String nombre, String apellido, String dni) 
	{
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public static boolean verificarDniInvalido(String dni) throws DniInvalido
	{
		boolean Dni = false;

		if(dni.matches("[0-9]{7,8}")) {
			Dni = true;
		}
		if(Dni == false) {
			throw new DniInvalido();
		}
		else return true;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws DniInvalido {
		
		this.dni = dni;
		/*if(Persona.verificarDniInvalido(dni)) {
			this.dni = dni;
		}
		else {
			System.out.println("NO SE PUDO CARGAR EL DNI");
		}*/
	}

	@Override
	public String toString() {
		return "Persona [NOMBRE: " + nombre + ", APELLIDO: " + apellido + ", DNI: " + dni + "]";
	}
	
	@Override
	public int compareTo(Persona o) {
		Character aVer1 = (o.getApellido()).charAt(0);
		Character aVer2 = this.apellido.charAt(0);
		
		int aComparar1 = aVer1.hashCode();
		int aComparar2 = aVer2.hashCode();
		
		
			if (o.getApellido().compareTo(this.apellido) == 0)
			    return 0;
			else
			if (aComparar1 < aComparar2)
			   return 1;
			else
			if (aComparar1 > aComparar2)
			   return -1;
			return 0;
	}
}
