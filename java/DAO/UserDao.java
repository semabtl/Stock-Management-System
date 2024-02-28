package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.User;

public class UserDao {
	private Connection con;
	private String query;
	private Statement s;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	//Kullan�c�n�n giti� yapmas� i�in metod
	public User userLogin(String email, String password) {
		User user = null;
		
		//Verilen e-posta ve �ifreye sahip bir kullan�c� var m� diye veritaban�na bak�l�r.
		try {
			query = "SELECT * FROM users WHERE email = '" + email + "' and password = '" + password + "' ";
			s = con.createStatement();
			rs = s.executeQuery(query);
			
			//Kullan�c� varsa, bilgileri veritaban�ndan al�n�r.
			if(rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userid"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setEmail(rs.getString("email"));
				user.setCompanyName(rs.getString("companyname"));
				user.setUserType(rs.getString("usertype"));
			}
	    	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	//Bir e-postaya sahip sadece tek bir kullan�c� vard�r. Bu nedenle e-posta �zerinden kullan�c� id bilgisi bulunabilir.
	public int findUserIdByEmail(String email) {
		int userId=0;
		
		//Kullan�c� id bilgisi users adl� kullan�c�lar tablosundan al�n�r.
		try {
			query = "SELECT userid FROM users WHERE email='" + email +"'";
			s = con.createStatement();
			rs = s.executeQuery(query);
			
			if(rs.next()) {
				userId = rs.getInt("userid");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userId;
	}
	
	public void createNewUser(String name, String surname, String companyName, String email, String password) throws SQLException {
		
			query = "INSERT INTO users (userid, name, surname, email, password, usertype, companyname) VALUES ( nextVal('userid_seq'), '" + name + "', '" + surname + "', '" + email + "', '" + password + "', 'Manager', '" + companyName + "' )"; 
			s = con.createStatement();
			s.executeUpdate(query);
				
		
	}
}
