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
	
	//Girilen barkoda sahip �r�n�n var olup olmad��� veritaban�ndan kontrol edilir.
	public boolean checkIfBarcodeExists(int barcode, int userId) {
		boolean exists = false;
		try {
			query = "SELECT * FROM products WHERE barcode = " + barcode + " AND userid = " + userId;
			s = connection.createStatement();
			rs = s.executeQuery(query);
			
			if(rs.next()) {
				exists = true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return exists;
	}
	public Basket createNewBasketObject(int barcode, int orderQuantity, String supplierName) {
		Basket basket = new Basket();
		basket.setBarcode(barcode);
		basket.setOrderQuantity(orderQuantity);
		basket.setSupplierName(supplierName);
		
		try {
			query = "SELECT * FROM products WHERE barcode=" + barcode;
			s = connection.createStatement();
			rs = s.executeQuery(query);
			
			if(rs.next()) {
				basket.setCategory(rs.getString("category"));
				basket.setCostPrice(rs.getDouble("costprice"));
				basket.setName(rs.getString("productname"));
				basket.setSellingPrice(rs.getDouble("sellingprice"));
				basket.setProductId(rs.getInt("productid"));
				basket.setTotalCost(basket.getCostPrice() * basket.getOrderQuantity());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return basket;
	}

}
