package controller.menu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    private Opciones opciones;
    private String[] descs;
    private static Scanner sc;

    public Menu(Opciones opciones){
        Menu.sc = new Scanner(System.in);
        this.opciones = opciones;
        this.descs = opciones.getDescs();
    }

    public void empezar(){
        String opc = "";
        String salir = Integer.toString(descs.length+1);

        for(;;) {
            System.out.println(this);
    
            System.out.print("Escoge una opción: ");
            opc = sc.next();
            System.out.println();

            if (opc.equals(salir)) break;
            opciones.ejecutarByNum(opc);

            pause("\nPulse una tecla para continuar...");
        }
    }

    public static void pause(String text){
        System.out.print(text);

        try {
            System.in.read();
        }
        catch (IOException e){
            System.out.println("Error en la lectura...");
        }

        System.out.println();
    }

    public static boolean leersn(){
        String sn = sc.next();

        return sn.equals("s") || sn.equals("S") ? true : false; // ""=="" no funcionaría en este caso
    }

    public static LocalDate dateInput(String text) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");

        LocalDate date = null;

        for (;;) {
            try { 
                System.out.print(text);
                String stringDate = sc.next();
                date = LocalDate.parse(stringDate, dateFormat);
                break; // Solo se ejecuta si la función de arriba no devuleve un error.
            } catch (DateTimeParseException e) {
                Menu.pause("Utilice el formato correcto para la fecha...");
            }
        }
        
        return date;
    }

    public static int inputInt(String text){
        int intNum;

        for(;;){
            try {
                System.out.print(text);
                String strNum = sc.next();
                intNum = Integer.parseInt(strNum);
                break;
            } catch (Exception e) {
                System.out.println("La cadena introducida no es un número...");
            }
        }
        
        return intNum;
    }

    public String toString(){
        String menu = "";

        int ind = 0;
        for (String desc : descs) menu += ++ind + ". " + desc + "\n";
        menu += ++ind + ". Salir.\n";

        return menu;
    }
}
