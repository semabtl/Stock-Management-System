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
		
		//Kaydolma sayfas�ndan girilen bilgiler al�n�r.
		String name = request.getParameter("new-name");
		String surname = request.getParameter("new-surname");
		String companyName = request.getParameter("new-company-name");
		String email = request.getParameter("new-email");
		String password = request.getParameter("new-password");
		
		try {
			//Yeni ki�i olu�turulur ve veri taban�na kaydedilir.
			UserDao userDao = new UserDao(DatabaseConnection.getConnection());
			userDao.createNewUser(name, surname, companyName, email, password);		
			
			//Kay�t i�lemi tamamland�ktan sonra kullan�c�ya i�lemin ba�ar�l� oldu�u belirtilir.
			response.sendRedirect("SignInCompleted.jsp");
			
		}catch(Exception e) {
			//Kay�t s�ras�nda bir hata olursa kullan�c�ya hata mesaj� g�sterilir.
			response.sendRedirect("ErrorMessage.jsp");
		}
		
		
			
		
	}

}
