package controller.gestiones.especificas;

import java.io.File;

import controller.menu.Opciones;
import model.domainobjects.*;
import model.services.*;
import util.Util;

public class GestionesEstacion implements Opciones {

	public GestionesEstacion() {

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
	
	private String pedirCodigo() {
		System.out.println("Introduce el codigo de la estación: ");
		return Util.introducirCadena();
	}

	public void mostrarRegistros() {
		GestorArchivos.fileIteratior(new File("historico.dat"),
				(p -> {
					if (Historico.class.cast(p)
						.getCodEstacion().equals(pedirCodigo()))
						System.out.println(p);
				}));
	}

	public void listarNavesAcopladas() {
		GestorArchivos.fileIteratior(new File("historico.dat"),
				(p -> {
					if (Historico.class.cast(p)
						.getCodEstacion().equals(pedirCodigo()))
						if(Historico.class.cast(p)
								.getHoraSalida().equals(null))
									System.out.println(p.getCodNave());
				}));
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