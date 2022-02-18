package controller.gestiones.especificas;

import controller.menu.Opciones;

public class GestionesNave implements Opciones {

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
			case "1": break;
			case "2": break;
			case "3": break;
			default:
				break;
		}
		
	}

	@Override
	public String[] getDescs() {	
		return new String[]{
			"Listar cargamento.",
			"Mostrar recorrido.",
			"Mostrar tipo"
		};
	}
    
}
