package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigLoader {

	private String db_type;
	private String db_name;
	private String db_url;
	private String db_user;
	private String db_pass;
	
	private Path ruta = Paths.get("Ficheros/Config.txt");
	
	private static ConfigLoader instance = null;
	
	public static synchronized ConfigLoader getInstance() {
		if(instance == null) {
			instance = new ConfigLoader();
		}
		return instance;
	}
	
	private ConfigLoader() {
		try(BufferedReader br = Files.newBufferedReader(ruta, StandardCharsets.UTF_8)){
			String texto = null;
			
			while((texto = br.readLine()) != null) {
				String[] lineaFichero = texto.split("=");
				switch (lineaFichero[0]) {
				case "db_type":
					if(lineaFichero.length == 2) {
						db_type = lineaFichero[1].trim();
					}
					break;
				case "db_url":
					if(lineaFichero.length == 2) {
						db_url = lineaFichero[1].trim();
					}
					break;
				case "db_name":
					if(lineaFichero.length == 2) {
						db_name = lineaFichero[1].trim();
					}
					break;
				case "db_user":
					if(lineaFichero.length == 2) {
						db_user = lineaFichero[1].trim();
					}
					break;
				case "db_pass":
					if(lineaFichero.length == 2) {
						db_pass = lineaFichero[1].trim();
					}
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public String getDb_type() {
		return db_type;
	}

	public String getDb_name() {
		return db_name;
	}

	public String getDb_url() {
		return db_url;
	}

	public String getDb_user() {
		return db_user;
	}

	public String getDb_pass() {
		return db_pass;
	}

}
