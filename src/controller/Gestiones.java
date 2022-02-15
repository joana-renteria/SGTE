package controller;
import java.util.Arrays;
import java.util.stream.Stream;

import controller.menu.*;

public class Gestiones implements Opciones{

    public Gestiones(){
        
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

    /* ESTACIONES */
    private void gestionesEstaciones() {
        GestionesCRUD opciones = new GestionesCRUD("estaciones.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir una nueva estación.",
                    "Mostrar registros en el histórico.",
                    "Mostrar naves acopladas actualmente.",
                    "Naves acopladas por código.",
                    "Naves acopladas por nombre.",
                    "Mostrar cargamento."
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": addEstacion(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    default:
                        break;
                }  
            }

            private void addEstacion() {
                System.out.println("¡CREANDO NUEVO ESTACIÓN!");
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }

    /* CARGAMENTOS */
    private void gestionesCargamentos() {
        GestionesCRUD opciones = new GestionesCRUD("cargamentos.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir un nuevo cargamento.",
                    "Mostrar registros en el histórico.",
                    "Mostrar ruta."
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": addHistorico(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    default:
                        break;
                }  
            }

            private void addHistorico() {
                System.out.println("¡CREANDO NUEVO CARGAMENTO!");
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }

    /* NAVES */
    private void gestionesNaves() {
        GestionesCRUD opciones = new GestionesCRUD("naves.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir una nueva nave.",
                    "Listar cargamento.",
                    "Mostrar recorrido."
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": addHistorico(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    default:
                        break;
                }  
            }

            private void addHistorico() {
                System.out.println("¡CREANDO NUEVO NAVE!");
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }
}
