package model.domainobjects.naves;

import model.domainobjects.Nave;

public class NavePrivada extends Nave {

    private String tipo;

    public NavePrivada(String pCodigo, String pNombre, String pTipo) {
        super(pCodigo, pNombre);
        this.tipo = pTipo;
    }

    public String toString(){
        return super.toString() + "\t" +
            this.tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }        
}
