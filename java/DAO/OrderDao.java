package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Order;
import Model.Product;

public class OrderDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs;
	private List<Order> orderList = new ArrayList<Order>();
	
	public OrderDao(Connection connection) {
		this.connection = connection;
	}
//	public List<Order> getAllOrders(){
//		List<Order> orders = new ArrayList<Order>();
//		
//		try {
//			query = "SELECT * FROM orders";
//		}
//	}
	public void addToList(Order order) {
		orderList.add(order);
	}
	
	public void createNewOrder(int barcode, int quantity, String supplierName, String orderDate, double totalCost, String status) {
		Order newOrder = new Order(orderDate, supplierName, totalCost, status);
		int orderId = 0;
		try {
			//�kinci ya da sonraki �r�nler girilirken farkl� order id geliyor. Farkl� gelmemesi laz�m.
				//Sipari� bilgileri veritaban�ndaki "orders" adl� tabloya eklenir.
				query = "INSERT INTO orders VALUES ( nextVal('orderid_seq'), '" + orderDate + "', '" + supplierName + "', " + totalCost + ", '" + status + "')";
				s = connection.createStatement();
				s.executeUpdate(query);

				//Eklenen sipari�in id'si veritaban�ndan al�n�r.
				query = "SELECT currval('orderid_seq')";
				s = connection.createStatement();
				rs = s.executeQuery(query);
				rs.next();
				
				orderId = rs.getInt("currval");
				newOrder.setOrderId(orderId);
		
				//Sipari� ve �r�n e�le�melerinin bulundu�u tabloya yeni sipari� bilgileri girilir.
				query = "INSERT INTO order_product VALUES (" + orderId + ", " + barcode + ", " + quantity + ")";
				s = connection.createStatement();
				s.executeUpdate(query);
				
				

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
