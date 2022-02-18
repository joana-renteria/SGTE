package model.domainobjects;

import java.io.Serializable;

public abstract class Nave implements Serializable, SistemaSGTE{
    
    private String codigo;
    private String nombre;
    
    public Nave(String pCodigo, String pNombre) {
        this.codigo = pCodigo;
        this.nombre = pNombre;
    }

	public String toString(){
		return this.codigo + "\t" + 
			this.nombre;
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
}
