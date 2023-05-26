package dao;

import java.util.ArrayList;

import model.City;

public interface CityDAO {

	ArrayList<City> getAll();
	
	ArrayList<City> getCitiesByCountry(String country);
}
