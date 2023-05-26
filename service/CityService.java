package service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.City;
import repository.CityRepository;

public class CityService {

	public ArrayList<City> listadoCiudades(){
		
		return CityRepository.getInstance().getAll();
	}
	
	public ArrayList<City> listadoCiudadesPaises(String country){
		return CityRepository.getInstance().getCitiesByCountry(country);
	}
	
	public void volcarEnFichero() {
		Path fichero = Paths.get("Ficheros/Resultado.txt");
		
		try(BufferedWriter bw = Files.newBufferedWriter(fichero, StandardCharsets.UTF_8)){
			ArrayList<City> listaFichero = new ArrayList<>();
			listaFichero = listadoCiudades();
			
			for (City city : listaFichero) {
				bw.write(city.toString());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
