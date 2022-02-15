package model.domainobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

import util.YaExisteException;

public class Estacion implements Serializable, SistemaSGTE{
	
	private String codigo;
	private String nombre;
	private String localizacion;
	
	private ArrayList<String> naves;
	
	public Estacion(String pCodigo) {
		this.codigo = pCodigo;
	}
	
	public Estacion(String pCodigo,
			String pNombre, String pLoc) {
		this.codigo = pCodigo;
		this.nombre = pNombre;
		this.localizacion = pLoc;
	}
	
	private boolean existeNave(Nave pNave) {
		Optional<String> nave = naves.stream()
				.filter(p -> p.equals(pNave.getCodigo()))
				.findFirst();
		return nave.isPresent();
	}
	
	private void addNave(Nave nNave) throws YaExisteException {
		if(!existeNave(nNave))
			naves.add(nNave.getCodigo());
		else
			throw new YaExisteException("nave");
	}

}
