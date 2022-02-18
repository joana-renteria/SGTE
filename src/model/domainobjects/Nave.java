package model.domainobjects;

import java.io.Serializable;

public class Nave implements Serializable, SistemaSGTE{
	
	private String codigo;
	private String nombre;
	
	public Nave(String pCodigo, String pNombre) {
		this.codigo = pCodigo;
		this.nombre = pNombre;
	}

	public String toString(){
		return "Código: " + codigo + "\t"
			+ "Nombre: " + nombre;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
