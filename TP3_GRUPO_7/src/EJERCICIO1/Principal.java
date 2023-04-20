package EJERCICIO1;


import java.util.Iterator;
import java.util.TreeSet;

public class Principal {

	public static void main(String[] args) {
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Archivos\\Personas.txt");
		
		TreeSet<Persona> listaPersonas = new TreeSet<Persona>(); // llena la lista de personas con el archivo Personas.txt
		try
		{
			archivo.llenarTS(listaPersonas);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
		finally
		{
			Iterator<Persona> it = listaPersonas.iterator();
			while(it.hasNext())
			{
				Persona per = (Persona)it.next();
				System.out.println(per.toString());
			}
		}
		
		
		
		Archivo archivo2 = new Archivo(); // crea archivo Resultado.txt y le escribe las lineas cargadas en la listaPersonas
		archivo2.setRuta("Archivos\\Resultado.txt");
		
		if(archivo2.existe())
		{
			System.out.println("Existe archivo");
		}
		else 
		{
			archivo2.crearArchivo();
		}
		
		Iterator<Persona> it = listaPersonas.iterator();
		while(it.hasNext())
		{
			Persona per = (Persona)it.next();
			archivo2.escribe_lineas(per.toString() + "\r\n");
		}

	}

}
