package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Connection.DatabaseConnection;
import DAO.OrderDao;
import Model.Basket;

@WebServlet("/add-new-order")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			//Tarih de�eri di�er servlet i�inde kullan�c�dan al�nm��t�. Bu de�er session �zerinden al�narak kullan�l�r
			HttpSession session = request.getSession();
			String orderDate = (String) session.getAttribute("newDate");
			
			ArrayList<Basket> orderList = (ArrayList<Basket>) session.getAttribute("basket-list");
			String userEmail = (String) session.getAttribute("email");
			
			OrderDao odao = new OrderDao(DatabaseConnection.getConnection());
			if(orderList != null) {
				if(!orderList.isEmpty()) {
					odao.createNewOrder(orderList, orderDate, userEmail);
					orderList.clear();
					response.sendRedirect("OrderListPage.jsp");
				}
			}
			else {
				System.out.println("List is null !!!");
				response.sendRedirect("ErrorMessage.jsp");
			}
		}
	}

}
