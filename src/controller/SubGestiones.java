package controller;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Supplier;

import controller.menu.Opciones;
import model.domainobjects.Historico;
import model.domainobjects.SistemaSGTE;
import model.services.GestorSGTE;

public class SubGestiones implements Opciones{
    private SistemaSGTE clazz;
    private GestorSGTE gestor;

    public SubGestiones(Class<? extends SistemaSGTE> clazz){
        try {
            this.clazz = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.gestor = new GestorSGTE<SistemaSGTE>(this.clazz);
    }

    @Override
    public void ejecutarByNum(String opc) {
        switch (opc) {
            case "1": opc_a(); break;
            case "2": opc_b(); break;
            case "3": opc_c(); break;
            case "4": opc_d(); break;
            default:
                break;
        }
    }

    @Override
    public String[] getDescs() {
        String simpleName = this.clazz.getClass().getSimpleName();
        
        return new String[]{
            "Añadir un nuevo " + simpleName + ".",
            "Leer un " + simpleName + " por código.",
            "Actualizar un " + simpleName + ".",
            "Eliminar un " + simpleName + "."
        };
    }

    private void opc_a() {
        
    }

    private void opc_b() {
        
    }

    private void opc_c() {
        
    }

    private void opc_d() {
       
    }
}
