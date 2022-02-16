package controller;

import controller.gestiones.GestionesSGTE;
import controller.menu.Menu;
import controller.menu.Opciones;

public class Main {
	public static void main(String[] args) {
		Opciones gestiones = new GestionesSGTE(); // Inicializamos las gestiones a realizar.
		Menu menu = new Menu(gestiones); // Inicializamos el menú con las gestiones.

		menu.empezar();
	}
}
