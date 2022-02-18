package model.domainobjects.naves;

import model.domainobjects.Nave;

public class NaveMilitar extends Nave {

    private int cantArmas;

    public NaveMilitar(String pCodigo, String pNombre, int pCantArmas) {
        super(pCodigo, pNombre);
        this.cantArmas = pCantArmas;
    }

    public String toString(){
        return super.toString() + "\t" +
            this.cantArmas;
    }

    public int getCantArmas() {
        return this.cantArmas;
    }

    public void setCantArmas(int cantArmas) {
        this.cantArmas = cantArmas;
    }
}
