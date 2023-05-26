package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.City;
import utils.DBConnection;

public class CityDAOMySql implements CityDAO {

	private final String SELECT_CITIES = "SELECT ID, Name, CountryCode, District, Population FROM CITY";
	private final String SELECT_CITIES_BY_COUNTRYNAME = "SELECT C.*" + " FROM CITY C  "
			+ " INNER JOIN COUNTRY CO ON CO.CODE = C.COUNTRYCODE" + " WHERE CO.NAME=?";

	@Override
	public ArrayList<City> getAll() {
		ArrayList<City> listaCiudades = new ArrayList<City>();

		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_CITIES);) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				City c = new City(
						rs.getInt("ID"), 
						rs.getString("Name"), 
						rs.getString("CountryCode"),
						rs.getString("District"), 
						rs.getInt("Population"));
				listaCiudades.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCiudades;
	}

	@Override
	public ArrayList<City> getCitiesByCountry(String country) {
		ArrayList<City> listaCiudadesPaises = new ArrayList<>();

		try (PreparedStatement stmt = DBConnection.getInstance().getConnection().prepareStatement(SELECT_CITIES_BY_COUNTRYNAME);) {
			
			stmt.setString(1, country);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				City c = new City(
						rs.getInt("ID"), 
						rs.getString("Name"), 
						rs.getString("CountryCode"),
						rs.getString("District"), 
						rs.getInt("Population"));
				
				listaCiudadesPaises.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCiudadesPaises;
	}

}
