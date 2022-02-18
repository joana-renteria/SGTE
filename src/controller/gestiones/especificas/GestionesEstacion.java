package controller.gestiones.especificas;

import java.util.ArrayList;
import java.util.List;

import controller.gestiones.GestionesDO;
import controller.menu.Opciones;
import model.domainobjects.*;
import model.services.*;

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

	public void mostrarRegistros() {
		final String codEstacion = GestionesDO.pedirCodigo();
		
		registros.foreach(r -> {
			if (codEstacion.equals(r.getCodEstacion()));
				System.out.println(r);
		});
	}

	public void listarNavesAcopladas() {
		final String codEstacion = GestionesDO.pedirCodigo();

		registros.foreach(r -> {
			if (codEstacion.equals(r.getCodEstacion())){
				if (r.getHoraSalida() == null) // Si no tiene hora de salida.
				System.out.println(naves.firstMatch(n -> n.getCodigo().equals(r.getCodNave()))); // Imprímase la nave con tal código.
			}
		});
	}

	// TODO: No funciona correctamente.
	public void mostrarCargamento() {
		final String codEstacion = GestionesDO.pedirCodigo();
		List<String> cods = new ArrayList<>();

		registros.foreach(r -> {
			if (codEstacion.equals(r.getCodEstacion())){ // Los registros de la estación introducida por el usuario.
				String codDescargado = r.getCodDescargado();

				if (codDescargado != null && !cods.contains(codDescargado)){ // Si alguna vez se ha descargado en la estación y lo hemos evaluado anteriormente.
					cods.add(codDescargado);

					Historico ultimoCargo = registros.lastMatch(r2 -> r2.getCodCargado().equals(r.getCodCargado()) && codEstacion.equals(r2.getCodEstacion())); // Último registro en el que es cargado a la nave.
					Historico ultimoDescargo = registros.lastMatch(r2 -> r2.getCodDescargado().equals(codDescargado) &&  codEstacion.equals(r2.getCodEstacion())); // Último registro en el que es descargado a la estación.

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