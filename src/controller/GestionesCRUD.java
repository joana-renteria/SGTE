package controller;

import controller.menu.Opciones;

public abstract class GestionesCRUD implements Opciones{
    String nombreClase;
    String[] descs;

    public GestionesCRUD(String nombreClase){
        this.nombreClase = nombreClase;
        descs = new String[]{
            "Leer un " + nombreClase,
            "Actualizar un " + nombreClase,
            "Eliminar un " + nombreClase
        };
    }

    /* MÉTODOS ABSTRACTOS */
    public abstract void extendEjecutarByNum(String opc); // Este método contendrás más opciones especificas de la clase.

    /* IMPLEMENTACIONES */
    
    // Hacemos override de getDescs() en la implementación cuando hayamos añadido las nuevas opciones a descs (si es que las hay);
    @Override
    public String[] getDescs() {
        return descs;
    }

    @Override
    public void ejecutarByNum(String opc) {
        switch (opc) {
            case "1": readObj(); break;
            case "2": updateObj(); break;
            case "3": deleteObj(); break;
            default: extendEjecutarByNum(opc); // De este modo podremos implementar más opciones.
                break;
        }
    } 

    // TODO: ACABAR
    private void readObj() {
    }

    private void updateObj() {
    }

    private void deleteObj() {
    }

}
