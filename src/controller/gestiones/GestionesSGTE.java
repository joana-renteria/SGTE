package controller.gestiones;
import java.util.Arrays;
import java.util.stream.Stream;

import controller.menu.*;

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

    /* ESTACIONES */
    private void gestionesEstaciones() {
        GestionesDO opciones = new GestionesDO("estaciones.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir una nueva estación.",
                };

                return Stream.concat(Arrays.stream(descs), Arrays.stream(extDescs))
                    .toArray(String[]::new);
            }

            @Override
            public void extendEjecutarByNum(String opc) {
                switch (opc) {
                    case "4": addDO(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": mostrarRegistros(); break;
                    case "6": navesAcopladas(); break;
                    case "7": navesAcopladasByCodigo(); break;
                    case "8": navesAcopladasByNombre(); break;
                    case "9": mostrarCargamento(); break;
                    default:
                        break;
                }  
            }

            @Override
            public void addDO() {
                // TODO SETDATOS
                System.out.println("¡CREANDO NUEVO ESTACIÓN!");
            }

            // GESTIONES ESPECÍFICAS
            private void mostrarRegistros() {
            }

            private void navesAcopladas() {
            }

            private void navesAcopladasByCodigo() {
            }

            private void navesAcopladasByNombre() {
            }

            private void mostrarCargamento() {
            }

            
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }

    /* CARGAMENTOS */
    private void gestionesCargamentos() {
        GestionesDO opciones = new GestionesDO("cargamentos.") {

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
                    case "4": addDO(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    default:
                        break;
                }  
            }

            @Override
            public void addDO() {
                // TODO Auto-generated method stub
                System.out.println("¡CREANDO NUEVO CARGAMENTO!");
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }

    /* NAVES */
    private void gestionesNaves() {
        GestionesDO opciones = new GestionesDO("naves.") {

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
                    case "4": addDO(); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    default:
                        break;
                }  
            }

            @Override
            public void addDO() {
                // TODO Auto-generated method stub
                System.out.println("¡CREANDO NUEVO NAVE!");                
            }
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }
}
