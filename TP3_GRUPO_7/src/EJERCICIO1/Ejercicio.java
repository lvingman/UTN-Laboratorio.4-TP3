package EJERCICIO1;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Ejercicio {
	
	public void resolver() {
		
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Archivos\\Personas.txt");
		
		if(archivo.existe())
		{
			crearLista();
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}
	
	public void resolverC() {
		
		
		Archivo archivo = new Archivo();
		archivo.setRuta("Archivos\\Personas.txt");
		
		if(archivo.existe())
		{
			TreeSet<Persona> personas = new TreeSet<>();
			archivo.llenarTS(personas);
			archivo.escribirResultado(personas);
			
			
		}
		else
		{
			System.out.println("No existe archivo");
		}
	}
	
	
	private void crearLista() {
		
		//Creo la lista que voy a llenar
		ArrayList<Persona> personas = new ArrayList<>();
		
		Persona persona = new Persona();
		
		
		FileReader entrada;
		try {
			entrada = new FileReader("Archivos\\Personas.txt");
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = "";
				while (linea != null) {
					//Leo y corto las lineas donde esta el guion
					linea = miBuffer.readLine();
					if(linea !=null) {
						String[] datos = linea.split("-");
						persona.setNombre(datos[0].trim());
						persona.setApellido(datos[1].trim());
						persona.setDni(datos[2].trim());
						personas.add(persona);
						System.out.println(persona.toString());						
					}
				} 
			
			miBuffer.close();
			entrada.close();
			
		}catch(IOException e) {
			System.out.println("No se encontro el archivo");
		}
		
		
		
	}
	
	private void escribirResultados() {
		
		//Creo la lista que voy a llenar
		TreeSet<Persona> personas = new TreeSet<>();
		
		
		
	}
}
