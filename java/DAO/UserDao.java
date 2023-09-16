package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
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
	public User userLogin(String email, String password) {
		User user = null;
		try {
			query = "SELECT * FROM users WHERE email = '" + email + "' and password = '" + password + "' ";
			s = con.createStatement();
			rs = s.executeQuery(query);
			
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
}
