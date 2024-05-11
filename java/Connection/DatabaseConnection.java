package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static Connection connection = null;
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				//Database connection is created.
				connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Product-Management", "postgres", "1307");
				Statement s = connection.createStatement();
		    	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
