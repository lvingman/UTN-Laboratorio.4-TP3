package EJERCICIO1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Archivo {
	
	private String ruta;

	// constructores
	public Archivo() {
		
	}
	
	public Archivo(String ruta) {
		this.ruta = ruta;
	}
	
	// gets & sets
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	// compruebo si existe el archivo
	public boolean existe()
	{
		File archivo = new File(ruta); // ruta puede recibir una ruta relativa o absoluta
		if(archivo.exists())
			return true;
		return false;
	}
	
	// lee el archivo
	public void lee_lineas() {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader miBuffer = new BufferedReader(entrada);
			
			String linea = "";
				while (linea != null) {
					linea = miBuffer.readLine();
					System.out.println(linea);
				} 
			
			miBuffer.close();
			entrada.close();
			
		}catch(IOException e) {
			System.out.println("No se encontro el archivo");
		}
		
	}
	public void llenarTS(TreeSet<Persona> persona) 
		{
			FileReader entrada;
			try
			{
				String linea;
				entrada = new FileReader(ruta);
				BufferedReader miBuffer = new BufferedReader(entrada);
				while((linea = miBuffer.readLine()) != null) {
					Persona p;
					try {
						p = lineaAPersona(linea);
						Persona.verificarDniInvalido(p.getDni());
						persona.add(p);
					}
					catch(DniInvalido ex) {
						System.out.println(ex.getMessage());
						
					}
				}
				miBuffer.close();
				entrada.close();
			}catch (IOException e) {
				System.out.println("No se encontro el archivo");
			}
		}
		
		public Persona lineaAPersona(String linea)
		{
			String[] p2 = linea.split("-");
			String nombre = p2[0];
			String apellido = p2[1];
			String dni = p2[2];
			
			return new Persona(nombre,apellido,dni);
		}


}
