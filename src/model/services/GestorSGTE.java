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
}