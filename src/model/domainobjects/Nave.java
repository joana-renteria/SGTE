package model.domainobjects;

import java.io.Serializable;

public class Nave implements Serializable, SistemaSGTE{
	
	private String codigo;
	private String nombre;
	
	public Nave(String pCodigo, String pNombre) {
		this.codigo = pCodigo;
		this.nombre = pNombre;
	}
}
