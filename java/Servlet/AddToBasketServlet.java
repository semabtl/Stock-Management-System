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
import DAO.BasketDao;
import DAO.ProductDao;
import Model.Basket;
import Model.Product;

@WebServlet("/add-to-basket")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<Basket> basketList = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		
		try(PrintWriter out = response.getWriter()){
			
			//Kullanýcýnýn girdiði bilgiler alýnýr.
			int newBarcode = Integer.parseInt(request.getParameter("new-barcode"));
			int orderQuantity = Integer.parseInt(request.getParameter("new-quantity"));
			String newSupplierName = request.getParameter("new-supplier");
			String newDate = request.getParameter("new-date");
			
			//Tarih deðerinin session üzerinden aktarýmý saðlanýr.
			session.setAttribute("newDate", newDate);
			
			//Kullanýcý id deðeri session üzerinden alýnýr.
			int userId = (int) session.getAttribute("userid");
			
			BasketDao bdao = new BasketDao(DatabaseConnection.getConnection());
			
			//Girilen barkoda sahip ürünün var olup olmadýðý kontrol edilir.
			boolean barcodeExists = bdao.checkIfBarcodeExists(newBarcode, userId);
			
			if(barcodeExists) {
				Basket basket = bdao.createNewBasketObject(newBarcode, orderQuantity, newSupplierName);
				
				//Liste boþsa ürün direkt olarak eklenir.
				if(basketList.isEmpty()) {
					basketList.add(basket);
				}
				//Liste boþ deðilse, ürünün listede olup olmadýðý kontrol edilir ve listede yoksa eklenir.
				else {
					ProductDao p = new ProductDao(DatabaseConnection.getConnection());
					if(p.containsThatProduct(basketList, basket.getBarcode())) {
						System.out.println("product exists in the list");
					}
					else {
						basketList.add(basket);
					}
				}
			}
			//Girilen barkoda sahip bir ürün yoksa, ...
			else {
				System.out.println("product is not real");
			}
			//HttpSession session = request.getSession();
			session.setAttribute("basket-list", basketList);
			response.sendRedirect("AddNewOrderPage.jsp");
		}
	}
	
}
