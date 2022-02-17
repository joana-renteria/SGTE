package controller;

import java.io.File;
import java.util.List;

import controller.gestiones.GestionesSGTE;
import controller.menu.*;
import model.domainobjects.*;
import model.services.GestorSGTE;

public class Main {
	public static void main(String[] args) {
		Opciones gestiones = new GestionesSGTE(); // Inicializamos las gestiones a realizar.
		Menu menu = new Menu(gestiones); // Inicializamos el menú con las gestiones.

		GestorSGTE gestor = new GestorSGTE();

		/*
		gestor.addObject(new Nave("NAV001", "NAVE_FROGA"));
		gestor.addObject(new Nave("NAV002", "NAVE2_FROGA"));
		

		List<Nave> naves = gestor.findObject(n -> true);
		naves.forEach(System.out::println);
		*/

		System.out.println(gestor.objectWhatFile(new Nave("", "")).getPath());
		System.out.println(gestor.objectWhatFile(new Estacion("")).getPath());
		System.out.println(gestor.objectWhatFile(new Historico()).getPath());
		System.out.println(gestor.objectWhatFile(new Cargamento("", "", "", 0.0, true)).getPath());

		// menu.empezar();
	}
}