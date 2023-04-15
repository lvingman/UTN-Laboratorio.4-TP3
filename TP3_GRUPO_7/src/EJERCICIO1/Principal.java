package EJERCICIO1;

public class Principal {

	public static void main(String[] args) {
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Archivos\\Personas.txt");
		
		if(archivo.existe())
		{
			System.out.println("Existe archivo");
			archivo.lee_lineas();
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}

}
