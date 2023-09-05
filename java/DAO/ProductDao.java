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
	
	
	public void createNewProduct(String name, String category, double costPrice, double sellingPrice, int quantity) {
		//Yeni ürün oluþturulur.
		Product newProduct = new Product(name, category, costPrice, sellingPrice, quantity);
		
		try {
			//Ürün veritabanýna eklenir.
			query = "INSERT INTO products VALUES ( nextVal('productid_seq'), nextVal('barcode_seq'), '" +
						name + "', '" + category  + "', " + costPrice + " , " + sellingPrice + " , " + quantity + " ) "; 
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
			
			//Ürünün id ve barkodu belirlenir. Diðer özellikleri ürün oluþturulurken ayarlanmýþtý.
			newProduct.setProductId(productId);
			newProduct.setBarcode(barcode);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
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
			product.setQuantity(rs.getInt("quantity"));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		
		try {
			query = "SELECT * FROM products";
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
				newProduct.setQuantity(rs.getInt("quantity"));
				
				products.add(newProduct);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
	public List<Basket> getBasketProducts(ArrayList<Basket> basketList){
		List<Basket> products = new ArrayList<Basket>();
		
		try {
			if(basketList.size() > 0) {
				for(Basket item:basketList) {
					query = "SELECT * FROM products WHERE barcode= " + item.getBarcode();
					s = connection.createStatement();
					rs = s.executeQuery(query);
					
					while(rs.next()) {
						Basket row = new Basket();
						row.setBarcode(rs.getInt("barcode"));
						row.setProductId(rs.getInt("productid"));
						row.setCategory(rs.getString("category"));
						row.setCostPrice(rs.getDouble("costprice") * item.getQuantity());
						row.setName(rs.getString("productname"));
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
