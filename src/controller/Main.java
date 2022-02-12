package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static String passwd = "miau";

	static String ficheroHistorico 		= "historico.dat";
	static String ficheroEstaciones 	= "estaciones.dat";
	static String ficheroNaves 			= "naves.dat";
	static String ficheroCargamento 	= "cargamento.dat";
	static String ficheroTripulantes	= "tripulantes.dat";

	public static void main(String[] args) {

		File fichHisto = new File(ficheroHistorico);
		File fichEstac = new File(ficheroEstaciones);
		File fichNaves = new File(ficheroNaves);
		File fichCargo = new File(ficheroCargamento);
		File fichTrips = new File(ficheroTripulantes);

		String opcs[] = {
				"Gestionar estaciones",
				"Gestionar naves",
				"Gestionar cargamento",
				"Gestionar tripulantes",
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
		System.out.println("Qu� desea hacer?");
		int input = sc.nextInt();
		if(input >= 1 && input <= l.size()) {
			return (input);
		}
		return -1;
	}
	

}
