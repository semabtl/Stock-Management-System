package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Product;


@WebServlet("/print-barcode")
public class PrintBarcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		try{			
			//Týklanan ürünün id'si bulunur.
			int id = Integer.parseInt(request.getParameter("id"));
			Product p = new Product();
			p.setProductId(id);
			
			//Týklanan ürünün id'si product-id isimli attribute'e verilir. Bu bilgi daha sonra farklý sayfalarda get metodu ile alýnabilir.
			HttpSession session = request.getSession();
			session.setAttribute("product-id-for-barcode", id);
			
			response.sendRedirect("Barcode.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
