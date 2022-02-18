package model.domainobjects;

import java.io.Serializable;

public class Estacion implements Serializable, SistemaSGTE{
    
    private String codigo;
    private String nombre;
    private String localizacion;

	public Estacion(String codigo, String nombre, String localizacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.localizacion = localizacion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocalizacion() {
		return this.localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
}
