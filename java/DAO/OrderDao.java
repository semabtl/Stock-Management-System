package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.DatabaseConnection;
import Model.Basket;
import Model.Order;
import Model.Product;

public class OrderDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs;
	
	
	public OrderDao(Connection connection) {
		this.connection = connection;
	}
	public List<Order> getAllOrdersOfUser(int userId){
		List<Order> orders = new ArrayList<Order>();
		
		try {
			//Tüm sipariþler tek tek okunarak listeye eklenir.
			query = "SELECT * FROM orders WHERE userid = " + userId ;
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				Order newOrder = new Order();
				newOrder.setOrderId(rs.getInt("orderid"));
				newOrder.setOrderDate(rs.getString("orderdate"));
				newOrder.setTotalCost(rs.getDouble("totalcost"));
				newOrder.setUserId(userId);
				
				orders.add(newOrder);
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public ArrayList<Integer> getOrderedProducts(int orderId){
		ArrayList<Integer> orderedProducts = new ArrayList<Integer>();
		
		try {
			query = "SELECT barcode FROM order_product WHERE orderid=" + orderId;
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				orderedProducts.add(rs.getInt("barcode"));
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return orderedProducts;
	}
	//Sipariþ listesinin toplam maliyeti hesaplanýr.
	public double calculateTotalListCost(ArrayList<Basket> productList) {
		double totalCost = 0;
		for(Basket product:productList) {
			totalCost += product.getTotalCost();
		}
		return totalCost;
	}
	
	public void createNewOrder(ArrayList<Basket> productList, String orderDate, String userEmail) {
		UserDao udao = new UserDao(DatabaseConnection.getConnection());
		int userId = udao.findUserIdByEmail(userEmail);
		
		Order newOrder = new Order();
		newOrder.setOrderDate(orderDate);
		newOrder.setTotalCost(calculateTotalListCost(productList));
		newOrder.setUserId(userId);
		
		try {
			//Sipariþ veritabanýna kaydedilir.
			query = "INSERT INTO orders (orderid, orderdate, totalcost, userid) VALUES ( nextVal('orderid_seq'), '" + orderDate + "', " + calculateTotalListCost(productList) + ", " + userId + ")" ;
			s = connection.createStatement();
			s.executeUpdate(query);
			
			for(Basket product:productList) {
				//Sipariþ içeriðindeki her ürün tek tek veritabanýna kaydedilir.
				query = "INSERT INTO order_product VALUES ( currval('orderid_seq'), " + product.getBarcode() + ", " +   product.getOrderQuantity() + ")"; 
				s = connection.createStatement();
				s.executeUpdate(query);
				
				//Her ürün için girilen satýcý ismi tek tek veritabanýna kaydedilir.
				query = "INSERT INTO supplier VALUES ( currval('orderid_seq'), " + product.getBarcode() + ", '" + product.getSupplierName() + "')";
				s = connection.createStatement();
				s.executeUpdate(query);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public String getSupplierName(int orderId, int barcode) {
		String supplierName = "";
		try {
			query = "SELECT suppliername FROM supplier WHERE orderid=" + orderId + " AND barcode=" + barcode;
			s = connection.createStatement();
			rs = s.executeQuery(query);
			
			if(rs.next()) {
				supplierName = rs.getString("suppliername");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return supplierName;
	}
}
