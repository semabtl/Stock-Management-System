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
	
	//Method for the user to log in
	public User userLogin(String email, String password) {
		User user = null;
		
		//The database is checked to see if there is a user with the given e-mail and password.
		try {
			query = "SELECT * FROM users WHERE email = '" + email + "' and password = '" + password + "' ";
			s = con.createStatement();
			rs = s.executeQuery(query);
			
			//If there is a user, the information is retrieved from the database.
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
	
	//There is only one user with an email. Therefore, user id can be found via e-mail.
	public int findUserIdByEmail(String email) {
		int userId=0;
		
		//User id information is retrieved from the "users" table.
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
