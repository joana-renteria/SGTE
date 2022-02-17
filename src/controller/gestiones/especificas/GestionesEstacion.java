package controller.gestiones.especificas;

import controller.menu.Opciones;
import model.domainobjects.Estacion;
import model.services.GestorSGTE;

public class GestionesEstacion implements Opciones {
	
	public GestionesEstacion() {
		// Añadir los gestores que fueran necesarios para operar en cada archivo.
	}

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
		case "1": mostrarRegistros(); break;
		case "2": listarNavesAcopladas(); break;
		case "3": buscarNavesAcopladasByCodigo(); break;
		case "4": buscarNavesAcopladasByNombre(); break;
		case "5": mostrarCargamento(); break;
		case "6": buscarCargamento(); break;
		default:
			break;
		}  
	}

	@Override
	public String[] getDescs() {
		String[] extDescs = new String[]{
				"Mostrar registros en el histórico.",
				"Mostrar naves acopladas actualmente.",
				"Buscar naves acopladas por código.",
				"Buscar naves acopladas por nombre.",
				"Mostrar cargamento.",
				"Buscar cargamento por código."
		};
		return extDescs;
	}

	public void mostrarRegistros() {
		gestorHistorico.listAll();
	}

	public void listarNavesAcopladas() {
		
	}

	public void buscarNavesAcopladasByCodigo() {
		
	}

	public void buscarNavesAcopladasByNombre() {
		
	}

	public void mostrarCargamento() {

	}
	
	public void buscarCargamento() {

	}

}