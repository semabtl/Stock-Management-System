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

/**
 * Servlet implementation class AddToBasketServlet
 */
@WebServlet("/add-to-basket")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Basket> productList = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()){
			
			Basket b = new Basket();
			b.setBarcode(Integer.parseInt(request.getParameter("new-barcode")));
			b.setOrderQuantity(Integer.parseInt(request.getParameter("new-quantity")));
			if(productList.isEmpty()) {
				productList.add(b);
				System.out.println(b.getBarcode());
			}
			else {
				if(containsThatProduct(productList, b.getBarcode())) {
					System.out.println("product exists in the list");
				}
				else {
					productList.add(b);
					System.out.println("product added");
				}
			}
		}
	}
	
	public static boolean containsThatProduct(ArrayList<Basket> productList, int barcode) {
		boolean contains = false;
		for(Basket b:productList) {
			if(b.getBarcode() == barcode) {
				contains = true;
			}
		}
		return contains;
	}

}
