package controller;
import controller.menu.*;

public class Gestiones implements Opciones{

   	CRUD crudEst = new CRUDEstacion();
   	CRUD crudNav = new CRUDNave();
   	CRUD crudCrg = new CRUDCargamento();
   	CRUD crudTrp = new CRUDTripulante();

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
            default:
                break;
        }
    }    

    @Override
    public String[] getDescs() {
        return new String[]{
				"Gestionar estaciones",
				"Gestionar naves",
				"Gestionar cargamento",
				"Gestionar tripulantes",
				"Salir"
        };
    }
  
    public String[] getDescsEstaciones() {
        return new String[]{
				"Listar estaciones",
				"Añadir estacion",
				"Eliminar Estacion",
				"Buscar estacion por codigo",
				"Buscar estacion por nombre",
				"Buscar estacion por localizacion",
				"Mostrar historico de una estacion (codigo)",
				"Gestionar estacion",
				"Salir"
        };
    }
  
    public String[] getDescsNaves() {
        return new String[]{
				"Listar naves",
				"Añadir nave",
				"Eliminar nave",
				"Buscar nave por nombre",
				"Buscar nave por codigo",
				"Mostrar historico de una nave (codigo)",
				"Gestionar nave",
				"Salir"
        };
    }
  
    public String[] getDescsCargamento() {
        return new String[]{
				"Listar cargamentos",
				"Añadir cargamento",
				"Eliminar cargamento",
				"Buscar cargamento por codigo",
				"Mostrar historico de un cargamento (codigo)",
				"Gestionar cargamento",
				"Salir"
        };
    }
  
    public String[] getDescsTripulantes() {
        return new String[]{
				"Listar tripulantes",
				"Añadir tripulante",
				"Eliminar tripulante",
				"Buscar tripulante por codigo",
				"Buscar tripulante por nombre-apellido",
				"Gestionar tripulante",
				"Salir"
        };
    }
  
  // LAS OPCIONES QUE SEAN
    
    //Gestionar estaciones
    private void opc_a() {

    }

    //Gestionar naves
    private void opc_b() {
        
    }

    //Gestionar cargamento
    private void opc_c() {
        
    }

    // Gestionar tripulantes
    private void opc_d() {
       
    }

    // Salir
    private void opc_e() {
        
    }

}
