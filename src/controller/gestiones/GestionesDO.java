package controller.gestiones;

import controller.menu.Opciones;

public abstract class GestionesDO implements Opciones{
    String nombreClase;
    String[] descs;

    public GestionesDO(String nombreClase){
        this.nombreClase = nombreClase;
        descs = new String[]{
            "Leer un " + nombreClase,
            "Actualizar un " + nombreClase,
            "Eliminar un " + nombreClase
        };
    }

    /* MÉTODOS ABSTRACTOS */
     
    public abstract void addDO(); // setDatos().

    /* IMPLEMENTACIONES */
    public void extendEjecutarByNum(String opc){
        // Este método contendrás más opciones especificas de la clase.
        // No implementamos ningún cuerpo para que no interfiera con el funcionamiento de las otras clases.
        // Puede ser sobreescrita por la implementación.
    }
    
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
