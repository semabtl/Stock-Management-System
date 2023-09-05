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
		
		//T�klanan �r�n�n id'si bulunur.
		int id = Integer.parseInt(request.getParameter("productId"));
		Product p = new Product();
		p.setProductId(id);
		
		//T�klanan �r�n�n id'si product-id isimli attribute'e verilir. Bu bilgi daha sonra farkl� sayfalarda get metodu ile al�nabilir.
		HttpSession session = request.getSession();
		session.setAttribute("product-id", id);
		
		//�r�n bilgisi sayfas�na y�nlendirme yap�l�r.
		response.sendRedirect("ProductInformation.jsp");
	}

	

}
