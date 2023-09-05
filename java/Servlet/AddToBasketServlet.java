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

import Model.Basket;

/**
 * Servlet implementation class AddToBasketServlet
 */
@WebServlet("/add-to-basket")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			ArrayList<Basket> basketList = new ArrayList<>();
			
			int barcode = Integer.parseInt(request.getParameter("new-barcode"));
			Basket basket = new Basket();
			basket.setBarcode(barcode);
			basket.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Basket> basket_list = (ArrayList<Basket>) session.getAttribute("basket-list");
			
			if(basket_list == null) {
				basketList.add(basket);
				session.setAttribute("basket-list", basketList);
				response.sendRedirect("AddNewOrderPage.jsp");
			} 
			else {
				basketList = basket_list;
				
				boolean exists = false;
				//Eklenmek istenen ürünün listede olup olmadýðý kontrol edilir.
				for(Basket b:basket_list) {
					if(b.getBarcode() == barcode) {
						exists = true;
						out.println(b.getBarcode());
						out.println("<h3 class=\"text-center\"> Product already added to order list");
					}
				}
				//Ürün listede yoksa eklenir.
				if(!exists) {
					basketList.add(basket);
					response.sendRedirect("AddNewOrderPage.jsp");
				}
			}
		}
	}

}
