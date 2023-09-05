package Model;

public class Order {
	private int orderId;
	private String orderDate;
	private String supplierName;
	private double totalCost;
	private String status;
	
	public Order() {
	}
	
	public Order(String orderDate, String supplierName, double totalCost, String status) {
		this.orderDate = orderDate;
		this.supplierName = supplierName;
		this.totalCost = totalCost;
		this.status = status;
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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
