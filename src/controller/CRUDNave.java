package controller;
import controller.CRUD;

public class CRUDNave implements CRUD {
	
	public CRUDNave() {
		
	}

	public String[] getDescsEstacion() {
        return new String[]{
				"Mostrar informacion",
				"Listar tripulantes",
				"Buscar tripulante por nombre",
				"Buscar tripulante por codigo",
				"Listar cargamento",
				"Cambiar nombre",
				"Mostrar Historico",
				"Mostrar recorrido",
				"Ultima localizacion conocida",
				"Salir"
        };
	}
	
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

	private void opc_a() {
		// TODO Auto-generated method stub
		
	}

	private void opc_b() {
		// TODO Auto-generated method stub
		
	}

	private void opc_c() {
		// TODO Auto-generated method stub
		
	}

	private void opc_d() {
		// TODO Auto-generated method stub
		
	}

    private void opc_e() {
		// TODO Auto-generated method stub
		
	}

}