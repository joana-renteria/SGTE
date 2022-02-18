package controller.gestiones.especificas;

import controller.gestiones.GestionesDO;
import controller.menu.Opciones;
import model.domainobjects.*;
import model.services.GestorArchivos;

public class GestionesCargamento implements Opciones {

	GestorArchivos<Historico> registros;
	GestorArchivos<Cargamento> cargamentos;
	GestorArchivos<Estacion> estaciones;
	
	public GestionesCargamento(){
		registros = new GestorArchivos<>("historico.dat", Historico.class);
		cargamentos =  new GestorArchivos<>("cargamentos.dat", Cargamento.class);
		estaciones = new GestorArchivos<>("estaciones.dat", Estacion.class);
	}

	@Override
	public void ejecutarByNum(String opc) {
		switch (opc) {
			case "1": mostrarRegistros(); break;
			case "2": mostrarLocDescarga(); break;
			default:
				break;
		}
	}

	@Override
	public String[] getDescs() {
		return new String[]{
			"Mostrar registros en el histórico.",
			"Mostrar localizaciones de descarga."
		};
	}

	public void mostrarLocDescarga(){
		final String codCargamento = GestionesDO.pedirCodigo();

		registros.foreach(r -> {
			if (codCargamento.equals(codCargamento)){
				System.out.println(estaciones.firstMatch(e -> r.getCodEstacion().equals(e.getCodigo())).getLocalizacion()); // Se imprimen las localizaciones en las que ha sido descargado.
			}
		});
	}

	public void mostrarRegistros(){
		final String codCargamento = GestionesDO.pedirCodigo();

		registros.foreach(r -> {
			if (codCargamento.equals(r.getCodDescargado()) || codCargamento.equals(r.getCodCargado())){ // Si aparece en cualquier parte del registro se muestra.
				System.out.println(r);
			}
		});
	}
}
