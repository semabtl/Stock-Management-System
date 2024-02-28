package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Product;
import Model.Stock;

public class StockDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs;
	
	
	public StockDao(Connection connection) {
		this.connection = connection;
	}
	
	public int getStockQuantity(int productId, int userId) {
		int quantity = 0;
		
		try {
			query = "SELECT quantity FROM stock WHERE productId = " + productId + " AND userid=" + userId;
			s = connection.createStatement();
			rs = s.executeQuery(query);
			
			//rs.next null deðilse quatity deðeri veritabanýnda mevcuttur. Aksi takdirde kayýt yoktur, quantity deðeri 0 olarak kalýr.
			if(rs.next()) {
				quantity = rs.getInt("quantity");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return quantity;
	}
	
	public List<Stock> getStockOfUser(int userId){
		List<Stock> stockProducts = new ArrayList<Stock>();
		
		try {
			query = "SELECT * FROM stock WHERE userid=" + userId;
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				Stock newStockProduct = new Stock();
				newStockProduct.setProductId(rs.getInt("productid"));
				newStockProduct.setStockId(rs.getInt("stockid"));
				newStockProduct.setQuantity(rs.getInt("quantity"));
				newStockProduct.setUserId(userId);
				
				stockProducts.add(newStockProduct);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return stockProducts;
	}
}
