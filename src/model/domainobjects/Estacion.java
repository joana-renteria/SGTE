package model.domainobjects;

import java.io.Serializable;

public class Estacion implements Serializable, SistemaSGTE{
	
	private String codigo;
	private String nombre;
	private String localizacion;
	
	public Estacion(String pCodigo) {
		this.codigo = pCodigo;
	}
	
	public Estacion(String pCodigo,
			String pNombre, String pLoc) {
		this.codigo = pCodigo;
		this.nombre = pNombre;
		this.localizacion = pLoc;
	}	
}
