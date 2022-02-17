package controller.gestiones;

import controller.menu.Opciones;

public abstract class GestionesDO<T> implements Opciones{
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
     
    public abstract T inputDatos(); // Método que pide al usuario rellenar los datos de un objeto y devuleve le objeto.

    /* IMPLEMENTACIONES */
    public void extendEjecutarByNum(String opc){
        // Este método contendrás más opciones especificas de la clase.
        // No escribimos nada en el cuerpo para que no interfiera con el funcionamiento de las otras clases.
        // Tiene que ser sobrecargada para implementar más opciones.
    }
    
    // Hacemos override de getDescs() en la herencia cuando hayamos añadido las nuevas opciones a descs (si es que las hay);
    @Override
    public String[] getDescs() {
        return descs;
    }

    @Override
    public void ejecutarByNum(String opc) {
        switch (opc) {
            case "1": mostrarObjByCodigo(); break;
            case "2": replaceObjByCodigo(); break;
            case "3": deleteObjByCodigo(); break;
            default: extendEjecutarByNum(opc); // De este modo podremos implementar más opciones.
                break;
        }
    }

    // TODO: ACABAR
    private void mostrarObjByCodigo() {
    }

    private void replaceObjByCodigo() {
    }

    private void deleteObjByCodigo() {
    } 
    
}
