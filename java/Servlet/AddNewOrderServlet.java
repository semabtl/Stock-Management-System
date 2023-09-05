package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.DatabaseConnection;
import DAO.OrderDao;
import Model.Order;

@WebServlet("/add-order")
public class AddNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddNewOrderPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			
			int barcode = Integer.parseInt(request.getParameter("new-barcode"));
			int quantity = Integer.parseInt(request.getParameter("new-quantity"));
			String supplierName = request.getParameter("new-supplier");
			String date = request.getParameter("new-date");
			
			OrderDao orderDao = new OrderDao(DatabaseConnection.getConnection());
			Order newOrder;
				
			//order.createNewOrder(barcode, quantity, supplierName, date, 4, "Ordered");
			
			if(request.getParameter("options").equals("Order")) {
				response.sendRedirect("index.jsp");
				
			}
			else if(request.getParameter("options").equals("Add Another Product")) {
				newOrder = new Order(date, supplierName, 0, "Ordered");
				orderDao.addToList(newOrder);
				response.sendRedirect("AddNewOrderPage.jsp");
			}		
		}
	}

}
