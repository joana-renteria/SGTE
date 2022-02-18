package controller.gestiones.especificas;

import java.util.ArrayList;
import java.util.List;

import controller.menu.Opciones;
import model.domainobjects.*;
import model.services.*;
import util.Util;

public class GestionesEstacion implements Opciones {
	GestorArchivos<Historico> registros;
	GestorArchivos<Nave> naves;
	GestorArchivos<Cargamento> cargamentos;

	public GestionesEstacion() {
		registros = new GestorArchivos<>("historico.dat", Historico.class);
		naves = new GestorArchivos<>("naves.dat", Nave.class);
		cargamentos =  new GestorArchivos<>("cargamentos.dat", Cargamento.class);
	}

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
		case "1": mostrarRegistros(); break;
		case "2": listarNavesAcopladas(); break;
		case "3": mostrarCargamento(); break;
		default:
			break;
		}  
	}

	@Override
	public String[] getDescs() {
		String[] extDescs = new String[]{
				"Mostrar registros en el histórico.",
				"Mostrar naves acopladas actualmente.",
				"Mostrar cargamento."
		};
		return extDescs;
	}
	
	private String pedirCodigo() {
		System.out.print("Introduce el codigo de la estación: ");
		return Util.introducirCadena();
	}

	public void mostrarRegistros() {
		registros.foreach(r -> {
					if (r.getCodEstacion().equals(pedirCodigo()))
						System.out.println(r);
				});
	}

	public void listarNavesAcopladas() {
		registros.foreach(r -> {
			if (r.getHoraSalida() == null) // Si no tiene hora de salida.
				System.out.println(naves.firstMatch(n -> n.getCodigo().equals(r.getCodNave()))); // Imprímase la nave con tal código.
		});
	}

	public void mostrarCargamento() {
		registros.foreach(r -> {
			List<String> cods = new ArrayList<>();
			
			if (r.getCodEstacion().equals(pedirCodigo())){ // Los registros de la estación introducida por el usuario.
				String codDescargado = r.getCodDescargado();

				if (codDescargado != null && !cods.contains(codDescargado)){ // Si alguna vez se ha descargado en la estación y lo hemos evaluado anteriormente.
					cods.add(codDescargado);

					Historico ultimoCargo = registros.lastMatch(r2 -> r2.getCodCargado().equals(r.getCodCargado())); // Último registro en el que es cargado a la nave.
					Historico ultimoDescargo = registros.lastMatch(r2 -> r2.getCodDescargado().equals(codDescargado)); // Último registro en el que es descargado a la estación.

					// Si la última vez que salió de la nave fue después de la última vez que entró, etonces el cargamento no está.
					// Solo si eso NO se cumple, se muestra el cargamento.
					if (!ultimoCargo.getHoraSalida().isAfter(ultimoDescargo.getHoraEntrada())) {
						System.out.println(cargamentos.firstMatch(c -> c.getCodigo().equals(codDescargado)));
					}
				}
			}
		});
	}
}