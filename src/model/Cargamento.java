package model;

public class Cargamento {
	
	private String codigo;
	private String descripcion;
	private String tipo;
	private double peso;
	private boolean peligroso;
	
	public Cargamento(String pCodigo, String pDescripcion,
			String pTipo, double pPeso, boolean pPeligroso) {
		this.codigo = pCodigo;
		this.descripcion = pDescripcion;
		this.tipo = pTipo;
		this.peso = pPeso;
		this.peligroso = pPeligroso;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isPeligroso() {
		return peligroso;
	}

	public void setPeligroso(boolean peligroso) {
		this.peligroso = peligroso;
	}
	
}
