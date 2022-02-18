package controller.gestiones.especificas;

import controller.menu.Opciones;

public class GestionesCargamento implements Opciones {

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
			case "1": break;
			case "2": break;
			default:
				break;
		}
	}

	@Override
	public String[] getDescs() {
		return new String[]{
			"Mostrar registros en el histórico.",
			"Mostrar ruta."
		};
	}
}
