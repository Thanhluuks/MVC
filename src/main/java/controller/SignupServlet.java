package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ListAccountDAO;
import model.Account;

/**
 * Servlet implementation class login
 */
//@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// TODO Auto-generated method stub
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest (HttpServletRequest request, HttpServletResponse response)
		       throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
		    request.setCharacterEncoding ("utf-8"); 
		    try {
		    	request.getSession(true).invalidate();
		    	//collect data form login form
		    	String user = request.getParameter("username");
		    	String password = request.getParameter("password");
		    	Account acc = new Account();
		    	acc.setUsr(user);
		    	acc.setPwd(password);
		    	HttpSession session = request.getSession(true);
		    	
		    	if(!acc.validate()) {
		    		session.setAttribute("error", acc.getMessage());
		    		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		    		rd.forward(request, response);
		    		return;
		    	}
		    	//Get user with account database
		    	ListAccountDAO la = new ListAccountDAO();
		    	if(la.isAvaliable(acc.getUsr())) {
		    		//add account info to database
		    		la.addAccount(acc);
		    		session.setAttribute("user", acc.getUsr());
		    		//login valid,now redirect to admin page
		    		response.sendRedirect("index.jsp");
		    	}
		    	else {
		    		session.setAttribute("error","Tài khoản đã đăng ký.");
		    	
		    		response.sendRedirect("signup.jsp");
		    	}
		    }
		    	catch (NullPointerException e){
		    		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		    		rd.forward(request, response);
		    	}
		    	catch (Exception ex) {
		    		response.getWriter().println(ex);
		    	}
		    	
		    
	}

}

