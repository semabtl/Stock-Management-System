package Model;

public class Stock {
	private int stockId;
	private int productId;
	private int quantity;
	
	public Stock() {
	}

	public Stock(int stockId, int productId, int quantity) {
		this.stockId = stockId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
