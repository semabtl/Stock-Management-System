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
import DAO.ProductDao;
import Model.Basket;
import Model.Product;

@WebServlet("/add-to-basket")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Basket> basketList = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			//Tüm özellikler set edilmedi !!!
			Basket basket = new Basket();
			basket.setBarcode(Integer.parseInt(request.getParameter("new-barcode")));
			basket.setOrderQuantity(Integer.parseInt(request.getParameter("new-quantity")));
			basket.setSupplierName(request.getParameter("new-supplier"));
			
			if(basketList.isEmpty()) {
				basketList.add(basket);
			}
			else {
				ProductDao p = new ProductDao(DatabaseConnection.getConnection());
				if(p.containsThatProduct(basketList, basket.getBarcode())) {
					System.out.println("product exists in the list");
				}
				else {
					basketList.add(basket);
				}
			}
			HttpSession session = request.getSession();
			session.setAttribute("basket-list", basketList);
			response.sendRedirect("AddNewOrderPage.jsp");
		}
	}
	
}
