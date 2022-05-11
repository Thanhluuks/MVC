package controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/BrandController")
public class BrandController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BrandController() {
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
		PrintWriter out = response.getWriter();

		// For paging variable
		int pages = 1, first = 0, last = 0;
		if (request.getParameter("page") != null) {
			pages = Integer.parseInt(request.getParameter("page"));

		}
		if (pages <= 0) {
			pages = 1;
		}
		request.setAttribute("back", pages == 1 ? 1 : pages - 1);
		request.setAttribute("next", pages + 1);
		try {
			int total = new ListProductDAO().getProductQty("");
			int endPage = (int)Math.ceil(total / 10);
			request.setAttribute("endPage", endPage);

			request.setAttribute("page", pages);
			if (total <= 10) {
				first = 0;
				last = total;
			} else {
				first = (pages - 1) * 10;
				last = 10;
			}
			String name = request.getParameter("search");
			request.setAttribute("search", name);
			List<Product> ls = new ListProductDAO().searchBrand(name, first, last);
			request.setAttribute("products", ls);
			// GET Search producs
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("Error");
			e.printStackTrace();
		}

	}

}
