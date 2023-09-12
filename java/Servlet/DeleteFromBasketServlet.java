package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Basket;

@WebServlet("/delete-from-basket")
public class DeleteFromBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Basket> basketList = (ArrayList<Basket>) session.getAttribute("basket-list");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(basketList != null) {
			ArrayList<Basket> productsToRemove = new ArrayList<>();
			for(Basket product:basketList) {
				if(product.getProductId() == id) {
					productsToRemove.add(product);
				}
			}
			basketList.removeAll(productsToRemove);
		}
		
		response.sendRedirect("Basket.jsp");
	}

}
