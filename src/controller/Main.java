package controller;

import java.time.LocalDateTime;

import controller.gestiones.GestionesSGTE;
import controller.menu.*;
import model.domainobjects.*;
import model.domainobjects.naves.*;
import model.services.GestorArchivos;


public class Main {
	public static void main(String[] args) {
		Opciones gestiones = new GestionesSGTE(); // Inicializamos las gestiones a realizar.
		Menu menu = new Menu(gestiones); // Inicializamos el menú con las gestiones.

		
		GestorArchivos<Estacion> estaciones = new GestorArchivos<>("estaciones.dat", Estacion.class);
		GestorArchivos<Historico> registros = new GestorArchivos<>("historico.dat", Historico.class);
		GestorArchivos<Nave> naves = new GestorArchivos<>("naves.dat", Nave.class);
		GestorArchivos<Cargamento> cargamentos = new GestorArchivos<>("cargamentos.dat", Cargamento.class);

		// SI HAY ALGÚN PROBLEMA CON LOS ARCHIVOS PRUEBA A ELIMINARLOS Y DESCOMENTAR EL CÓDIGO DE ABAJO 1 ÚNICA VEZ
		// PARA QUE DE ESTE MODO SE VUELVAN A GENERAR.

		/*
		// Añadimos cargamentos al archivo.
		cargamentos.addObject(new Cargamento("CRG001", "Cargamento 1", false, 23)); // Está inicialmente en NCG001
		cargamentos.addObject(new Cargamento("CRG002", "Cargamento 2", false, 144));  // EST001
		cargamentos.addObject(new Cargamento("CRG003", "Cargamento 3", false, 93)); // EST002
		cargamentos.addObject(new Cargamento("CRG004", "Cargamento 4", true, 543)); // NCG002
		cargamentos.addObject(new Cargamento("CRG005", "Cargamento 5", true, 72)); // MIL001
		cargamentos.addObject(new Cargamento("CRG006", "Cargamento 6", true, 988)); // EST006

		// Añadimos naves de diferentes tipos al archivo.
		naves.addObject(new NaveMilitar("MIL001", "Nave Militar 1", 17));
		naves.addObject(new NaveMilitar("MIL002", "Nave Militar 2", 23));

		naves.addObject(new NaveCargamento("NCG001", "Nave Cargamento 1", 19));
		naves.addObject(new NaveCargamento("NCG002", "Nave Cargamento 2", 17));

		naves.addObject(new NavePrivada("PRV001", "Nave Privada 1", "Turística"));
		naves.addObject(new NavePrivada("PRV002", "Nave Privada 2", "Presidencial"));
		

		// Añadimos estaciones al archivo estaciones.dat.
		estaciones.addObject(new Estacion("EST001", "Estación 1", "Vía Láctea"));
		estaciones.addObject(new Estacion("EST002", "Estacion 2", "Puerto del Sistema Solar"));
		estaciones.addObject(new Estacion("EST003", "Estacion 3", "Ciudad Martitz"));
		estaciones.addObject(new Estacion("EST004", "Estacion 4", "Andrómeda"));
		estaciones.addObject(new Estacion("EST005", "Estacion 5", "Olymp"));
		estaciones.addObject(new Estacion("EST006", "Estacion 6", "Nuevos Planetas Unidos"));

		
		// Añadimos registros al archivo registros.dat
		registros.addObject(new Historico("EST001", "NCG001", LocalDateTime.of(2498, 12, 22, 18, 32, 24), LocalDateTime.of(2498, 12, 23, 18, 32, 24), "CRG001", "CRG002", "Llevar a Ciudad Martitz."));
		registros.addObject(new Historico("EST003", "NCG001", LocalDateTime.of(2498, 12, 25, 18, 32, 24), null, "CRG002", null, "Dejar cargo.")); // Nave sigue acoplada.
		registros.addObject(new Historico("EST006", "MIL001", LocalDateTime.of(2498, 11, 22, 18, 32, 24), LocalDateTime.of(2498, 12, 23, 18, 32, 24), null, "CRG006", "Urgencia: sacar de NPU."));
		*/

		// EL CÓDIGO COMENTADO CREA REGISTROS DE NCG001 QUE HA DEJADO CARGAMENTO EN EST001 Y HA COGIDO OTRO PARA LLEVARLO A EST003 Y SIGUE ACOPLADA EN EST003
		// EST003 TIENE A NCG001 ACOPLADO Y EL CARGAMENTO CRG002
		// EST006 TIENE ACOPLADA MIL001 Y EL CARGAMENTO CRG006
		
		menu.empezar();
	}
}