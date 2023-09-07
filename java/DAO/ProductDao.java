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
		//Yeni �r�n olu�turulur.
		Product newProduct = new Product(name, category, costPrice, sellingPrice);
		
		try {
			//�r�n veritaban�na eklenir.
			query = "INSERT INTO products VALUES ( nextVal('productid_seq'), nextVal('barcode_seq'), '" +
						name + "', '" + category  + "', " + costPrice + " , " + sellingPrice + " ) "; 
			s = connection.createStatement();
			s.executeUpdate(query);
			
			//Eklenen �r�n�n id'si veritaban�ndan al�n�r.
			query = "SELECT currval('productid_seq')";
			s = connection.createStatement();
			rs = s.executeQuery(query);
			rs.next();
			int productId = rs.getInt("currval");
			
			//Eklenen �r�n�n barkodu veritaban�ndan al�n�r.
			query = "SELECT currval('barcode_seq')";
			s = connection.createStatement();
			rs = s.executeQuery(query);
			rs.next();
			int barcode = rs.getInt("currval");
			
			//�r�n�n id ve barkodu belirlenir. Di�er �zellikleri �r�n olu�turulurken ayarlanm��t�.
			newProduct.setProductId(productId);
			newProduct.setBarcode(barcode);
			
			query = "INSERT INTO stock VALUES ( nextVal('stockid_seq'), " + productId + ", " + quantity + ")";
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
				
				products.add(newProduct);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}

	//AddToBasketServlet i�indeydi. Buraya ta��d�m. Orada productdao instance olu�turup bu metodu �a��r�yprum art�k.
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
