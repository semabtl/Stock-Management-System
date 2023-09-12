package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Basket;
import Model.Order;
import Model.Product;

public class OrderDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs, rs2;
	
	
	public OrderDao(Connection connection) {
		this.connection = connection;
	}
	public List<Order> getAllOrders(){
		List<Order> orders = new ArrayList<Order>();
		
		try {
			//T�m sipari�ler tek tek okunarak listeye eklenir.
			query = "SELECT * FROM orders";
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				Order newOrder = new Order();
				newOrder.setOrderId(rs.getInt("orderid"));
				newOrder.setOrderDate(rs.getString("orderdate"));
				newOrder.setStatus(rs.getString("status"));
				newOrder.setTotalCost(rs.getDouble("totalcost"));
				
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
	//Sipari� listesinin toplam maliyeti hesaplan�r.
	public double calculateTotalListCost(ArrayList<Basket> productList) {
		double totalCost = 0;
		for(Basket product:productList) {
			totalCost += product.getTotalCost();
		}
		return totalCost;
	}
	
	public void createNewOrder(ArrayList<Basket> productList, String orderDate) {
		Order newOrder = new Order();
		newOrder.setOrderDate(orderDate);
		newOrder.setStatus("Ordered");
		newOrder.setTotalCost(calculateTotalListCost(productList));
		
		try {
			//Sipari� veritaban�na kaydedilir.
			query = "INSERT INTO orders VALUES ( nextVal('orderid_seq'), '" + orderDate + "', " + calculateTotalListCost(productList) + ", 'Ordered')" ;
			s = connection.createStatement();
			s.executeUpdate(query);
			
			for(Basket product:productList) {
				//Sipari� i�eri�indeki her �r�n tek tek veritaban�na kaydedilir.
				query = "INSERT INTO order_product VALUES ( currval('orderid_seq'), " + product.getBarcode() + ", " +   product.getOrderQuantity() + ")"; 
				s = connection.createStatement();
				s.executeUpdate(query);
				
				//Her �r�n i�in girilen sat�c� ismi tek tek veritaban�na kaydedilir.
				query = "INSERT INTO supplier VALUES ( currval('orderid_seq'), " + product.getBarcode() + ", '" + product.getSupplierName() + "')";
				s = connection.createStatement();
				s.executeUpdate(query);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
