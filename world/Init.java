package world;

import java.util.ArrayList;
import java.util.Scanner;

import model.City;
import service.CityService;
import utils.DBConnection;

public class Init {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//DBConnection.getInstance().getConnection();
		
		/*
		CityDAOMySql citymysql = new CityDAOMySql();
		ArrayList<City> listaCiudades = new ArrayList<City>();
		
		listaCiudades = citymysql.getAll();
		
		for (City city : listaCiudades) {
			System.out.println(city);
		}
		*/
		
		CityService cs = new CityService();
		ArrayList<City> listaCiudades = new ArrayList<City>();
		
		int opc = 0;
		
		do {
			System.out.println("1- Mostrar listado ciudades");
			System.out.println("2- Mostrar listadoCiudadesPaises");
			System.out.println("3- Volcar a fichero todas las ciudades");
			System.out.println("4- Salir del programa.");
			opc = sc.nextInt();
			
			switch (opc) {
			case 1:
				listaCiudades = cs.listadoCiudades();
				for (City city : listaCiudades) {
					System.out.println(city);
				}
				break;
			case 2:
				listaCiudades = cs.listadoCiudadesPaises("Aruba");
				for (City city : listaCiudades) {
					System.out.println(city);
				}
				break;
			case 3:
				cs.volcarEnFichero();
				break;
			case 4:
				System.out.println("Saliendo del menu.");
				break;
			}
		} while (opc > 0 && opc < 4);
		
		sc.close();
		
	}
}
