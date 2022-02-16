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

public class GestorSGTE<T extends SistemaSGTE> {
	// Creamos un mapa con las clases y los ficheros correspondientes.
    private Map<Class<? extends SistemaSGTE>, File> ficheros = new HashMap<>(Map.ofEntries(
        entry(Historico.class, new File("historico.dat")),
        entry(Nave.class, new File("naves.dat")),
        entry(Cargamento.class, new File("cargamentos.dat")),
        entry(Estacion.class, new File("estaciones.dat"))
    ));

	File fich;

	public GestorSGTE(File fich) {	
		fich = this.fich;
	}

	// Devuelve true si ha podido añadirse, false si no.
	public boolean addObject(T t){
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
			if(!fich.exists()){
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

	// Devuelve el objeto a buscar por su código.
	public T readObject(String cod){
		return null;
		
	}

	// Devuelve true si ha podido realizar la acción al objeto, false si no.
	public boolean updateObject(T t){
		return false;
	}

	// Devuelve true si ha podido eliminarlo, false si no.
	public boolean deleteObject(){
		return false;
	}

	public List<T> matchObject(Function<T, Boolean> func){
		List<T> lista = new ArrayList<T>();

		try {
			FileInputStream fis = new FileInputStream(fich);
			ObjectInputStream oos = new ObjectInputStream(fis);

			T obj;

			try {
				obj = (T) oos.readObject();
				if (func.apply(obj)) lista.add(obj);
			} catch (EOFException e) {
				// Se han leído todos los objetos del archivo.
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error, no han podido leerse objetos.");
		}

		return lista;
	}

}
