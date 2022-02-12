package controller;
import controller.menu.*;

public class Gestiones implements Opciones{

    public Gestiones(){
    }

    @Override
    public void ejecutarByNum(String opc) {
        switch (opc) {
            case "1": opc_a(); break;
            case "2": opc_b(); break;
            case "3": opc_c(); break;
            case "4": opc_d(); break;
            case "5": opc_e(); break;
            case "6": opc_f(); break;
            case "7": opc_g(); break;
            case "8": opc_h(); break;
            case "9": opc_i(); break;
            default:
                break;
        }
    }    

    @Override
    public String[] getDescs() {
        return new String[]{
            "Opcion 1",
            "Opcion 2" // añadir más.
        };
    }
  
  // LAS OPCIONES QUE SEAN
    
    private void opc_a() {
        
    }

    private void opc_b() {
        
    }

    private void opc_c() {
        
    }

    private void opc_d() {
       
    }

    private void opc_e() {
        
    }

    private void opc_f() {
        
    }

    private void opc_g() {
        
    }

    private void opc_h() {
        
    }

    private void opc_i() {
        
        
    }
}
