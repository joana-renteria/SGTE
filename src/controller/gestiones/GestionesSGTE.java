package controller.gestiones;
import java.util.Arrays;
import java.util.stream.Stream;

import controller.gestiones.especificas.GestionesCargamento;
import controller.gestiones.especificas.GestionesEstacion;
import controller.gestiones.especificas.GestionesNave;
import controller.menu.*;
import model.domainobjects.Cargamento;
import model.domainobjects.Estacion;
import model.domainobjects.Nave;
import model.services.GestorSGTE;

public class GestionesSGTE implements Opciones{

    public GestionesSGTE(){
        
    }

    @Override
    public void ejecutarByNum(String opc) {
        switch (opc) {
            case "1": gestionesNaves(); break;
            case "2": gestionesCargamentos(); break;
            case "3": gestionesEstaciones(); break;
            default:
                break;
        }
    }

    @Override
    public String[] getDescs() {
        return new String[]{
            "Gestionar naves.",
            "Gestionar cargamentos.",
            "Gestionar estaciones."
        };
    }

    /* NAVES */
    private void gestionesNaves() {
        GestionesDO<Nave> opciones = new GestionesDO<>("nave.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir una nueva nave.",
                    "Gestiones específicas."
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": inputDatos(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": (new Menu(new GestionesNave())).empezar(); break; // Comenzar las gestiones específicas de las naves.
                    default:
                        break;
                }  
            }

            @Override
            public Nave inputDatos() {
                // ACABAR
                System.out.println("¡CREANDO NUEVO NAVE!"); 
                return null;               
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }

    /* CARGAMENTOS */
    private void gestionesCargamentos() {
        GestionesDO<Cargamento> opciones = new GestionesDO<>("cargamento.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir un nuevo cargamento.",
                    "Gestiones específicas."
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": inputDatos(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": (new Menu(new GestionesCargamento())).empezar(); break;
                    default:
                        break;
                }  
            }

            @Override
            public Cargamento inputDatos() {
                // IMPLEMENTAR
                System.out.println("¡CREANDO NUEVO CARGAMENTO!");
                return null;
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }

    /* ESTACIONES */
    private void gestionesEstaciones() {
        GestionesDO<Estacion> opciones = new GestionesDO<>("estación.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir una nueva estación.",
                    "Gestiones específicas."
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": inputDatos(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": (new Menu(new GestionesEstacion())).empezar(); break;
                    default:
                        break;
                }  
            }

            @Override
            public Estacion inputDatos() {
                // TODO SETDATOS
                System.out.println("¡CREANDO NUEVO ESTACIÓN!");
                return null;
            }           
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }
}
