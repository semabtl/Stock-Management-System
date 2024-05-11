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
			//All orders are read one by one from the database and added to the list.
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
	//The total cost of the order list is calculated.
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
			//The order is saved to the database.
			query = "INSERT INTO orders (orderid, orderdate, totalcost, userid) VALUES ( nextVal('orderid_seq'), '" + orderDate + "', " + calculateTotalListCost(productList) + ", " + userId + ")" ;
			s = connection.createStatement();
			s.executeUpdate(query);
			
			for(Basket product:productList) {
				//Each product in the order list is saved to the database one by one.
				query = "INSERT INTO order_product VALUES ( currval('orderid_seq'), " + product.getBarcode() + ", " +   product.getOrderQuantity() + ")"; 
				s = connection.createStatement();
				s.executeUpdate(query);
				
				//The supplier name entered for each product is saved to the database one by one.
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
