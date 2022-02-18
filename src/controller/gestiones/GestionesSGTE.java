package controller.gestiones;

import java.rmi.server.SocketSecurityException;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.plaf.synth.SynthSpinnerUI;

import controller.gestiones.especificas.*;
import controller.menu.*;
import model.domainobjects.*;
import model.domainobjects.naves.*;
import model.services.*;
import util.*;

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
                    case "4": System.out.println(inputDatos()); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": (new Menu(new GestionesNave())).empezar(); break; // Comenzar las gestiones específicas de las naves.
                    default:
                        break;
                }  
            }

            @Override
            public Nave inputDatos() {
                System.out.println("1. Crear una nueva nave de cargamento.");
                System.out.println("2. Crear una nueva nave militar.");
                System.out.println("3. Crear una nueva nave privada.");

                int tipoNave = 0;
                for (;;){
                    System.out.print("\nIntroduce una opción: ");
                    tipoNave = Util.leerInt();

                    if(tipoNave >= 1 || tipoNave <= 3) break;

                    System.out.println("No es una opción...");
                }

                Nave nave = null;

                System.out.print("Introduce el codigo de la nave: ");
                String codigo = Util.introducirCadena();
        
                System.out.print("Introduce nombre de la nave: ");
                String nombre = Util.introducirCadena();

                switch (Integer.toString(tipoNave)) {
                    case "1":
                        System.out.print("Introduce la capacidad de la nave: ");
                        int capacidad = Util.leerInt();

                        nave = new NaveCargamento(codigo, nombre, capacidad);
                        break;
                    
                    case "2":
                        System.out.print("Introduce la cantidad de armas de la nave: ");
                        int cantArmas = Util.leerInt();
                
                        nave = new NaveMilitar(codigo, nombre, cantArmas);
                        break;

                    case "3":
                        System.out.print("Introduce el tipo de nave: ");
                        String tipo = Util.introducirCadena();

                        nave = new NavePrivada(codigo, nombre, tipo);
                        break;

                    default:
                        System.out.println("El número no corresponde a ninguna opción.");
                        break;
                }

                return nave;
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
                    case "4": System.out.println(inputDatos()); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": (new Menu(new GestionesCargamento())).empezar(); break;
                    default:
                        break;
                }  
            }

            @Override
            public Cargamento inputDatos() {
                System.out.print("Introduce el codigo del cargamento: ");
                String codigo = Util.introducirCadena();
        
                System.out.print("Introduce descripcion del cargamento: ");
                String descripcion = Util.introducirCadena();
            
                System.out.print("Introduce si el cargamento es peligroso o no (s/n): ");
                boolean peligroso = Menu.leersn();
        
                System.out.print("Introduce la masa del cargamento: ");
                int masa = Util.leerInt();
        
                return new Cargamento(codigo, descripcion, peligroso, masa);
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
                    case "4": System.out.println(inputDatos()); break; // GestionesCRUD solo tiene 3 opciones por lo que siempre se empieza por 4.
                    case "5": (new Menu(new GestionesEstacion())).empezar(); break;
                    default:
                        break;
                }  
            }

            @Override
            public Estacion inputDatos() {
                System.out.print("Introduce el código de la estación: ");
                String codigo = Util.introducirCadena();

                System.out.print("Introduce el nombre de la localización: ");
                String nombre = Util.introducirCadena();

                System.out.print("Introduce la localización de la estación: ");
                String localizacion = Util.introducirCadena();

                return new Estacion(codigo, nombre, localizacion);
            }           
        };   
        
        Menu menu = new Menu(opciones);
        menu.empezar();
    }
}
