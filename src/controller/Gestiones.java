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
            case "1": gestionesHistorico(); break;
            case "2": gestionesNaves(); break;
            case "3": gestionesCargamentos(); break;
            case "4": gestionesEstaciones(); break;
            case "5": gestionesTripulantes(); break; 
            default:
                break;
        }
    }

    @Override
    public String[] getDescs() {
        return new String[]{
            "Gestionar histórico.",
            "Gestionar naves.",
            "Gestionar cargamentos.",
            "Gestionar estaciones.",
            "Gestionar tripulantes."
        };
    }

    private void gestionesHistorico() {
        GestionesCRUD opciones = new GestionesCRUD("histórico.") {

            @Override
            public String[] getDescs() {
                String[] extDescs = new String[]{
                    "Añadir un nuevo histórico.",
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
                System.out.println("¡CREANDO NUEVO HISTÓRICO!");
            }
        };   

        (new Menu(opciones)).empezar();
    }

    private void gestionesTripulantes() {
    }

    private void gestionesEstaciones() {
    }

    private void gestionesCargamentos() {
    }

    private void gestionesNaves() {
    }
}
