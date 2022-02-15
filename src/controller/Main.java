package controller;

import controller.menu.Menu;
import controller.menu.Opciones;

public class Main {
	public static void main(String[] args) {
		Opciones gestiones = new Gestiones(); // Inicializamos las gestiones a realizar.
		Menu menu = new Menu(gestiones); // Inicializamos el menú con las gestiones.

		menu.empezar();
	}
}
