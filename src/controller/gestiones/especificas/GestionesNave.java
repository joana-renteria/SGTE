package controller.gestiones.especificas;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

import controller.gestiones.GestionesDO;
import controller.menu.Opciones;
import model.domainobjects.*;
import model.services.GestorArchivos;
import util.YaExisteException;

public class GestionesNave implements Opciones {

	GestorArchivos<Historico> registros;
	GestorArchivos<Nave> naves;
	GestorArchivos<Cargamento> cargamentos;
	GestorArchivos<Estacion> estaciones;

	public GestionesNave() {
		registros = new GestorArchivos<>("historico.dat", Historico.class);
		naves = new GestorArchivos<>("naves.dat", Nave.class);
		cargamentos =  new GestorArchivos<>("cargamentos.dat", Cargamento.class);
		estaciones = new GestorArchivos<>("estaciones.dat", Estacion.class);
	}

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
			case "1": listarCargamento(); break;
			case "2": mostrarRecorrido(); break;
			case "3": mostrarTipo(); break;
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

	// TODO: No funciona correctamente.
	private void listarCargamento() {
		List<String> cods = new ArrayList<>();
		
		final String codNave = GestionesDO.pedirCodigo();

		registros.foreach(r -> {
			try {
				if (r.getCodNave().equals(codNave)){ // Analizamos los registros de esa nave.
					String codCargado = r.getCodCargado();
					System.out.println(codCargado);
	
					if(codCargado != null && !cods.contains(codCargado)){
						cods.add(codCargado);

						Historico ultimoCargo = registros.lastMatch(r2 -> r2.getCodCargado().equals(codCargado) && r2.getCodNave().equals(codNave));
						// System.out.println(ultimoCargo);
						Historico ultimoDescargo = registros.lastMatch(r2 -> r2.getCodDescargado().equals(r.getCodDescargado()) && r2.getCodNave().equals(codNave));

						
						// System.out.println(ultimoDescargo);
	
						if (ultimoCargo.getHoraSalida().isAfter(ultimoDescargo.getHoraEntrada())){
							System.out.println(cargamentos.firstMatch(c -> c.getCodigo() == r.getCodCargado()));
						}
					}
				}
			} catch (NullPointerException e) {
				// Se continua.
			}
		});
	}

	private void mostrarRecorrido() {
		final String codNave = GestionesDO.pedirCodigo();

		registros.foreach(r -> {
			if (codNave.equals(r.getCodNave())){
				System.out.print(" --> ");
				System.out.print(estaciones.firstMatch(e -> e.getCodigo().equals(r.getCodEstacion())).getLocalizacion());
			}
			System.out.println();
		});
	}

	private void mostrarTipo() {
		final String codNave = GestionesDO.pedirCodigo();

		Nave clase = naves.firstMatch(n -> n.getCodigo().equals(codNave));
		
		if (clase != null) {
			System.out.println(clase
				.getClass()
				.getSimpleName()
			);

			return;
		}

		System.out.println("La nave no existe...");
	}
}
