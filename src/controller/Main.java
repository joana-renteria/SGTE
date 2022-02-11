package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String passwd = "miau";

	public static void main(String[] args) {

		String fichero = "fich.dat";

		String opcs[] = {
				"Gestionar estaciones",
				"Gestionar naves",
				"Gestionar tripulantes",
				"Gestionar cargamento",
				"Salir"
		};

		boolean continuar = true;
		while(continuar) {
			int opcion = opciones(opcs);
			String input = null;
			switch (opcion) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			}
		}

	}

	public static int opciones(String[] s) {
		List<String> l = Arrays.asList(s);
		for(int i = 0; i < l.size(); i++) {
			System.out.println((i+1) + ") " + l.get(i));
		}
		System.out.println("Qué desea hacer?");
		int input = sc.nextInt();
		if(input >= 1 && input <= l.size()) {
			return (input);
		}
		return -1;
	}
	

}
