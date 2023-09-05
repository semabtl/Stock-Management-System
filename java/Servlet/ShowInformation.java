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

/**
 * Servlet implementation class ShowInformation
 */
@WebServlet("/show-information")
public class ShowInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//Týklanan ürünün id'si bulunur.
		int id = Integer.parseInt(request.getParameter("productId"));
		Product p = new Product();
		p.setProductId(id);
		
		//Týklanan ürünün id'si product-id isimli attribute'e verilir. Bu bilgi daha sonra farklý sayfalarda get metodu ile alýnabilir.
		HttpSession session = request.getSession();
		session.setAttribute("product-id", id);
		
		//Ürün bilgisi sayfasýna yönlendirme yapýlýr.
		response.sendRedirect("ProductInformation.jsp");
	}

	

}
