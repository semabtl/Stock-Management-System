package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StockDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs;
	
	
	public StockDao(Connection connection) {
		this.connection = connection;
	}
	
	public int getStockQuantity(int productId) {
		int quantity = 0;
		
		try {
			query = "SELECT quantity FROM stock WHERE productId = " + productId;
			s = connection.createStatement();
			rs = s.executeQuery(query);
			rs.next();
			
			quantity = rs.getInt("quantity");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return quantity;
	}
}
