package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DatabaseConnection;
import DAO.UserDao;


@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("SignIn.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		//Kaydolma sayfasýndan girilen bilgiler alýnýr.
		String name = request.getParameter("new-name");
		String surname = request.getParameter("new-surname");
		String companyName = request.getParameter("new-company-name");
		String email = request.getParameter("new-email");
		String password = request.getParameter("new-password");
		
		try {
			//Yeni kiþi oluþturulur ve veri tabanýna kaydedilir.
			UserDao userDao = new UserDao(DatabaseConnection.getConnection());
			userDao.createNewUser(name, surname, companyName, email, password);		
			
			//Kayýt iþlemi tamamlandýktan sonra kullanýcýya iþlemin baþarýlý olduðu belirtilir.
			response.sendRedirect("SignInCompleted.jsp");
			
		}catch(Exception e) {
			//Kayýt sýrasýnda bir hata olursa kullanýcýya hata mesajý gösterilir.
			response.sendRedirect("ErrorMessage.jsp");
		}
		
		
			
		
	}

}
