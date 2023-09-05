package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DatabaseConnection;
import DAO.ProductDao;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddProductPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			//Kullan�c�n�n formdan girdi�i yeni �r�n de�erleri al�n�r.
			String name = request.getParameter("new-name");
			String category = request.getParameter("new-category");
			double costPrice = Double.parseDouble(request.getParameter("new-costPrice"));
			double sellingPrice = Double.parseDouble(request.getParameter("new-sellingPrice"));
			int quantity = Integer.parseInt(request.getParameter("new-quantity"));
			
			//�r�n olu�turulur ve veritaban�na eklenir.
			ProductDao pdao = new ProductDao(DatabaseConnection.getConnection());
			
			pdao.createNewProduct(name, category, costPrice, sellingPrice, quantity);
			
			response.sendRedirect("index.jsp");
		}
	}
//Barkod veritabann�nda varsa say�s� toplan�p g�ncellenmeli.
}
