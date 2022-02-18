package controller.gestiones;

import controller.menu.Opciones;
import java.io.File;
import java.lang.annotation.Repeatable;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;

import model.domainobjects.*;
import model.services.GestorArchivos;
import util.Util;

public abstract class GestionesDO<T extends SistemaSGTE> implements Opciones{
    String nombreClase;
    String[] descs;

    private Map<Class<? extends SistemaSGTE>, String> ficheros = new HashMap<>(Map.ofEntries(
        entry(Historico.class, "historico.dat"),
        entry(Nave.class, "naves.dat"),
        entry(Cargamento.class, "cargamentos.dat"),
        entry(Estacion.class, "estaciones.dat")
    ));

    GestorArchivos<? extends SistemaSGTE> gestor;

    public GestionesDO(Class<? extends SistemaSGTE> clazz){
        this.nombreClase = clazz.getSimpleName();

        this.gestor = new GestorArchivos<>(ficheros.get(clazz), clazz);

        descs = new String[]{
            "Leer un " + nombreClase,
            "Actualizar un " + nombreClase,
            "Eliminar un " + nombreClase,
            "Mostrar todos"
        };
    }

    /* MÉTODOS ABSTRACTOS */
     
    public abstract <T extends SistemaSGTE> T inputDatos(); // Método que pide al usuario rellenar los datos de un objeto y devuleve le objeto.

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
            case "2": replaceObject(); break;
            case "3": gestor.deleteObject(obj -> GestionesDO.pedirCodigo().equals(obj.getCodigo())); break;
            case "4": mostrarTodos(); break;
            default: extendEjecutarByNum(opc); // De este modo podremos implementar más opciones.
                break;
        }
    }

    // TODO: ACABAR
    private void mostrarObjByCodigo() {
        String cod = GestionesDO.pedirCodigo();

        System.out.println(gestor.firstMatch(o -> cod.equals(o.getCodigo())));
    }


    public void mostrarTodos(){
        gestor.foreach(o -> System.out.println(o));
    }
    
    public void replaceObject(){
        System.out.print("Introduce el código del objeto a reemplazar: ");
        String cod = GestionesDO.pedirCodigo();
        
        if (gestor.firstMatch(o -> cod.equals(o.getCodigo())) != null){
            T obj = inputDatos();

            obj.setCodigo(cod); // NOS ASEGURAMOS DE QUE EL CÓDIGO SEA EL MISMO.

            gestor.replaceObject((o -> cod.equals(o.getCodigo())), obj);

            return;
        }

        System.out.println("El código introducido no pertenece a ningún objeto...");
    }

    public static String pedirCodigo() {
		System.out.print("Introduce el código: ");
		return Util.introducirCadena();
	}
}
