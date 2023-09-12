package Model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private String orderDate;
	private String status;
	private double totalCost;
	private List<Basket> orderedProducts = new ArrayList<Basket>();
	
	public Order() {
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public List<Basket> getOrderedProducts() {
		return orderedProducts;
	}

	public void setOrderedProducts(List<Basket> orderedProducts) {
		this.orderedProducts = orderedProducts;
	}
	
	
}
