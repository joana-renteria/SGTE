package model;

public class Nave {
	
	private String codigo;
	private String nombre;
	
	public Nave(String pCodigo,
			String pNombre) {
		this.codigo = pCodigo;
		this.nombre = pNombre;
	}
	
	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}
	
	private void setNombre(String pNombre) {
		this.nombre = pNombre;
	}

}
