package model.services;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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

	public GestorSGTE(T t) {	
		this.fich = ficheros.get(t.getClass());
	}

	// Devuelve true si ha podido añadirse, false si no.
	public boolean addObject(T t){
		return false;
	}

	// Devuelve el objeto a buscar por su código.
	public T readObject(String cod){
		return null;
	}

	// Devuelve true si ha podido realizar la acción al objeto, false si no.
	public boolean updateObject(){
		return false;
	}

	// Devuelve true si ha podido eliminarlo, false si no.
	public boolean deleteObject(){
		return false;
	}

}
