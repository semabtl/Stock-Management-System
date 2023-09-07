package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Basket;

public class BasketDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs;
	
	
	public BasketDao(Connection connection) {
		this.connection = connection;
	}
	
	public Basket createNewBasketObject(int barcode, int orderQuantity, String supplierName, String date) {
		Basket basket = new Basket();
		basket.setBarcode(barcode);
		basket.setOrderQuantity(orderQuantity);
		basket.setSupplierName(supplierName);
		basket.setOrderDate(date);
		
		try {
			query = "SELECT * FROM products WHERE barcode=" + barcode;
			s = connection.createStatement();
			rs = s.executeQuery(query);
			rs.next();
			
			basket.setCategory(rs.getString("category"));
			basket.setCostPrice(rs.getDouble("costprice"));
			basket.setName(rs.getString("productname"));
			basket.setSellingPrice(rs.getDouble("sellingprice"));
			basket.setProductId(rs.getInt("productid"));
			basket.setTotalCost(basket.getCostPrice() * basket.getOrderQuantity());

		}catch(Exception e) {
			e.printStackTrace();
		}
		return basket;
	}

}
