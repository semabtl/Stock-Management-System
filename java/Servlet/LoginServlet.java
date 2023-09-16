package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DatabaseConnection;
import Model.User;
import DAO.UserDao;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("LoginPage.jsp");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			//Login sayfasýndan girilen e-mail ve þifre alýnýr.
			String email = request.getParameter("login-email");
			String password = request.getParameter("login-password");
			
			//Girilen e-mail ve þifreye sahip kullanýcýnýn bulunmasý için veritabaný baðlantýsý kurulur ve userLogin metodu çaðrýlýr.
			UserDao udao = new UserDao(DatabaseConnection.getConnection());
			User user = udao.userLogin(email, password);
			
			//Eðer bu bilgilere sahip bir kullanýcý mevcutsa, anasayfaya yönlendirilir. Deðilse giriþ yapýlamaz ve uyarý verilir.
			if(user!=null) {
				request.getSession().setAttribute("auth", user);
				response.sendRedirect("index.jsp");
			}
			else {
				out.print("user login failed");
			}
		}
	}

}
