package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private Connection conn = null; //este atributo se usa para guardar los datos necesarios para realizar la conexion.
	
    private static DBConnection instance; //este atributo se usa para guardarse a si mismo.
   
    	//synchronized es un modificador que asegura atomicidad, es decir
	//solo puede ser accedido por un hilo de ejecucion a la vez.
    public static synchronized DBConnection getInstance() {
    	if(instance == null) {
    		instance = new DBConnection();
    	}
		return instance;
    }
    
    private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			String url = ConfigLoader.getInstance().getDb_url() + ConfigLoader.getInstance().getDb_name();
			String user = ConfigLoader.getInstance().getDb_user();
			String pass = ConfigLoader.getInstance().getDb_pass();
			
			conn = DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e){
			e.printStackTrace();
		}
    }
    
    public Connection getConnection() {
    	return conn;
    }
	
    public void destroyConnection() {
    	try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
    }
    
    
}
