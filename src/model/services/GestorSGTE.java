package model.services;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Map.entry;

import model.domainobjects.Cargamento;
import model.domainobjects.Estacion;
import model.domainobjects.Historico;
import model.domainobjects.Nave;
import model.domainobjects.SistemaSGTE;

public class GestorSGTE {
	// Creamos un mapa con las clases y los ficheros correspondientes.
    private Map<Class<? extends SistemaSGTE>, File> ficheros = new HashMap<>(Map.ofEntries(
        entry(Historico.class, new File("historico.dat")),
        entry(Nave.class, new File("naves.dat")),
        entry(Cargamento.class, new File("cargamentos.dat")),
        entry(Estacion.class, new File("estaciones.dat"))
    ));

	public GestorSGTE() {	
		// No recibe nada.
	}

	public File getObjectFile(SistemaSGTE t){
		return ficheros.get(t.getClass());
	}

	// Función que sirve para buscar un objeto de tipo 
	public static void printObject(File fich, Function<Object, Boolean> func){

		try {
			FileInputStream fis = new FileInputStream(fich);
			ObjectInputStream oos = new ObjectInputStream(fis);

			Object obj;
			
			boolean continuar = true;

			try {
				while(continuar){
					obj = oos.readObject();
					if (func.apply(obj)) {
						System.out.println(obj);
						continuar = false;
					}; // Se añade si la condición se cumple para el objeto actual.
				}
			} catch (EOFException e) {
				// Se han leído todos los objetos del archivo.
				oos.close();
				fis.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error, no han podido leerse objetos.");
		}
		
	}

	// Función que sirve para buscar varios objetos de tipo 
	public static void printObjects(File fich, Function<Object, Boolean> func){

		try {
			FileInputStream fis = new FileInputStream(fich);
			ObjectInputStream oos = new ObjectInputStream(fis);

			Object obj;
			
			boolean continuar = true;

			try {
				for(;;){
					obj = oos.readObject();
					if (func.apply(obj)) {
						System.out.println(obj);
					}; // Se añade si la condición se cumple para el objeto actual.
				}
			} catch (EOFException e) {
				// Se han leído todos los objetos del archivo.
				oos.close();
				fis.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error, no han podido leerse objetos.");
		}
		
	}

	// Devuelve true si ha podido añadirse, false si no.
	public boolean addObject(SistemaSGTE t){

		File fich = getObjectFile(t);

		if(fich == null) return false; // Si por algún motivo no resulta estar mapeado no se trabaja con el objeto.

		boolean fichExiste = fich.exists(); // Comprobamos si existe antes de hacer nada con él.
		boolean added = false;

		try {
			// Se inicializan los Stream como si el archivo existiera para no sobreescribir en caso de que lo hiciera.
			FileOutputStream fos = new FileOutputStream(fich, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos){
				protected void writeStreamHeader() throws IOException{
					reset();
				}
			};

			// Si es que no existe se crea.
			if(!fichExiste){
				fos = new FileOutputStream(fich); 
				oos = new ObjectOutputStream(fos);
			}

			oos.writeObject(t);

			oos.close();
			fos.close();
			
			added = true;
		} catch (IOException e) {
			System.out.println("Error, no ha podido añadirse el objeto.");
		}

		return added;
	}

	public static void fileManipulation(File fich, Function<Object, Boolean> func){

		File auxFich = new File("." + fich.getPath() + ".sgteman");

		try {
			FileOutputStream fos = new FileOutputStream(auxFich);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			try {
				FileInputStream fis = new FileInputStream(fich);
				ObjectInputStream ois = new ObjectInputStream(fis);
	
				Object obj;
	
				try {
					for(;;){
						obj = ois.readObject();
						if (func.apply(obj)) {
							
						}; // Se añade si la condición se cumple para el objeto actual.
					}
				} catch (EOFException e) {
					// Se han leído todos los objetos del archivo.
					ois.close();
					fis.close();
				}
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("Error, no han podido leerse objetos.");
			}

			oos.close();
			fos.close();

		} catch (IOException e1) {
			System.out.println("No se ha podido cambiar el archivo.");
		}

		
	}

	// Devuelve true si ha podido realizar reemplazar el objeto.
	public boolean replaceObject(File fich, Function<Object, Boolean> func, Object obj){
		return false;
	}

	// Devuelve true si ha podido eliminarlo, false si no.
	public boolean deleteObject(File fich, Function<Object, Boolean> func){
		return false;
	}

	// Creamos una clase igual que BiConsumer pero que lance las excepciones que vamos a utilizar.
    public interface ThrowerBiConsumer<T, U> {
        void accept(T t, U u) throws ClassNotFoundException, IOException, EOFException;
    }
}