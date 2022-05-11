package controller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListProductDAO;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	public void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset = utf-8");
		try {
			HttpSession session = request.getSession(true);
			String idd = request.getParameter("id");
			String action = request.getParameter("action");
			int id = Integer.parseInt(idd);
			if (action.equalsIgnoreCase("add")) {
				if (session.getAttribute("cart") == null)
					session.setAttribute("cart", new Cart());
				String quant =request.getParameter("quantity");
				int quantity = Integer.parseInt(quant);
				Product p = new ListProductDAO().getProduct(id);
				p.setNumber(quantity);
				Cart c = (Cart)session.getAttribute("cart");
				c.add(new Product(p.getId(),p.getName(),p.getDescription(),p.getPrice(),p.getSrc(),p.getType(),p.getBrand(),p.getNumber()));
			}
			else if (action.equalsIgnoreCase("delete")) {
				Cart c = (Cart)session.getAttribute("cart");
				c.remove(id);
			}
			response.sendRedirect("cart.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().println(e);
		}

	}

}
