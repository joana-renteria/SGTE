package model.domainobjects;

import java.io.Serializable;

public class Cargamento implements Serializable, SistemaSGTE{
	
	private String codigo;
	private String descripcion;
	private String tipo;
	private double peso;
	private boolean peligroso;
	
	public Cargamento(String pCodigo, String pDescripcion, String pTipo, double pPeso, boolean pPeligroso) {
		this.codigo = pCodigo;
		this.descripcion = pDescripcion;
		this.tipo = pTipo;
		this.peso = pPeso;
		this.peligroso = pPeligroso;
	}	
}
