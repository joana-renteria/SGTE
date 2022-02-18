package controller.gestiones.especificas;

import controller.menu.Opciones;

public class GestionesCargamento implements Opciones {

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
			case "1": mostrarRegistros(); break;
			case "2": mostrarRuta(); break;
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

	public void mostrarRuta(){

	}

	public void mostrarRegistros(){

	}
}
