package model.domainobjects;

import java.io.Serializable;

public class Cargamento implements Serializable, SistemaSGTE{
	
	private String codigo;
    private String descripcion;
    private boolean peligroso;
    private int masa;
    
    public Cargamento(String pCodigo, String pDescripcion, boolean pPeligroso, int pMasa) {
        this.codigo = pCodigo;
        this.descripcion = pDescripcion;
        this.peligroso = pPeligroso;
        this.masa = pMasa;
    }

	public String toString(){
		return codigo + "\t" + 
			descripcion + "\t" +
			peligroso + "\t" +
			masa;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isPeligroso() {
		return this.peligroso;
	}

	public boolean getPeligroso() {
		return this.peligroso;
	}

	public void setPeligroso(boolean peligroso) {
		this.peligroso = peligroso;
	}

	public int getMasa() {
		return this.masa;
	}

	public void setMasa(int masa) {
		this.masa = masa;
	}
}
