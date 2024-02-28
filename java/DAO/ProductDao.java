package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Basket;
import Model.Product;

public class ProductDao {
	private Connection connection;
	private String query;
	private Statement s;
	private ResultSet rs;
	
	
	public ProductDao(Connection connection) {
		this.connection = connection;
	}
	
	
	public void createNewProduct(String name, String category, double costPrice, double sellingPrice, int quantity, int userId) {
		//Yeni ürün oluþturulur.
		Product newProduct = new Product(name, category, costPrice, sellingPrice);
		
		try { 
			//Ürün veritabanýna eklenir.
			query = "INSERT INTO products (productid, barcode, productname, category, costprice, sellingprice, userid) VALUES ( nextVal('productid_seq'), nextVal('barcode_seq'), '" +
						name + "', '" + category  + "', " + costPrice + " , " + sellingPrice + ", " + userId +" ) "; 
			s = connection.createStatement();
			s.executeUpdate(query);
			
			//Eklenen ürünün id'si veritabanýndan alýnýr.
			query = "SELECT currval('productid_seq')";
			s = connection.createStatement();
			rs = s.executeQuery(query);
			rs.next();
			int productId = rs.getInt("currval");
			
			//Eklenen ürünün barkodu veritabanýndan alýnýr.
			query = "SELECT currval('barcode_seq')";
			s = connection.createStatement();
			rs = s.executeQuery(query);
			rs.next();
			int barcode = rs.getInt("currval");
			
			//Ürünün id ve barkodu ile ürünü ekleyen kullanýcýnýn id bilgisi belirlenir. Diðer özellikleri ürün oluþturulurken ayarlanmýþtý.
			newProduct.setProductId(productId);
			newProduct.setBarcode(barcode);
			newProduct.setUserId(userId);
			
			query = "INSERT INTO stock (stockid, productid, quantity, userid) VALUES ( nextVal('stockid_seq'), " + productId + ", " + quantity + ", " + userId + ")";
			s = connection.createStatement();
			s.executeUpdate(query);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Product getProductByBarcode(int barcode) {
		Product product = new Product();
		
		try {
			query = "SELECT * FROM products WHERE barcode = " + barcode ;
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			rs.next();
			
			product.setProductId(rs.getInt("productid"));
			product.setBarcode(rs.getInt("barcode"));
			product.setName(rs.getString("productname"));
			product.setCategory(rs.getString("category"));
			product.setCostPrice(rs.getDouble("costprice"));
			product.setSellingPrice(rs.getDouble("sellingprice"));
			product.setUserId(rs.getInt("userid"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public Product getProductById(int id) {
		Product product = new Product();
		
		try {
			query = "SELECT * FROM products WHERE productid = " + id ;
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			rs.next();
			
			product.setProductId(rs.getInt("productid"));
			product.setBarcode(rs.getInt("barcode"));
			product.setName(rs.getString("productname"));
			product.setCategory(rs.getString("category"));
			product.setCostPrice(rs.getDouble("costprice"));
			product.setSellingPrice(rs.getDouble("sellingprice"));
			product.setUserId(rs.getInt("userid"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getAllProductsOfUser(int userId){
		List<Product> products = new ArrayList<Product>();
		
		try {
			query = "SELECT * FROM products WHERE userid=" + userId ;
			s = connection.createStatement(); 
			rs = s.executeQuery(query);
			
			while(rs.next()) {
				Product newProduct = new Product();
				newProduct.setProductId(rs.getInt("productid"));
				newProduct.setBarcode(rs.getInt("barcode"));
				newProduct.setName(rs.getString("productname"));
				newProduct.setCategory(rs.getString("category"));
				newProduct.setCostPrice(rs.getDouble("costprice"));
				newProduct.setSellingPrice(rs.getDouble("sellingprice"));
				newProduct.setUserId(userId);
				
				products.add(newProduct);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public boolean containsThatProduct(ArrayList<Basket> basketList, int barcode) {
		boolean contains = false;
		for(Basket product:basketList) {
			if(product.getBarcode() == barcode) {
				contains = true;
			}
		}
		return contains;
	}
}
