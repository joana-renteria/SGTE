package controller.gestiones.especificas;

import controller.menu.Opciones;

public class GestionesEstacion implements Opciones {
	
	public static GestorSGTE<Historico> gestorHistorico;
	
	public GestionesEstaciones() {
		gestorHistorico = new GestorSGTE(new File("historico.dat"));
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
				"Buscar cargamento por codigo"
		};
		return extDescs;
	}

	public void mostrarRegistros() {
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