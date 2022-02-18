package model.domainobjects.naves;

import model.domainobjects.*;

public class NaveCargamento extends Nave {
	private int capacidad;
    
    public NaveCargamento(String pCodigo, String pNombre, int pCapacidad) {
		super(pCodigo, pNombre);
        this.capacidad = pCapacidad;
    }

	public String toString(){
		return super.toString() + "\t" +
            this.capacidad;
	}
    
	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
