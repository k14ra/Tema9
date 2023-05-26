package repository;

import java.util.ArrayList;

import dao.CityDAOMySql;
import model.City;

public class CityRepository {

	private CityDAOMySql dao;
	
	private static CityRepository instance;
	
	public static synchronized CityRepository getInstance() {
		if(instance == null) {
			instance = new CityRepository();
		} return instance;
	}
	
	private CityRepository() {
		this.dao = new CityDAOMySql();
	}
	
	public ArrayList<City> getAll(){
		return dao.getAll();
	}
	
	public ArrayList<City> getCitiesByCountry(String country){
		return dao.getCitiesByCountry(country);
	}
}
