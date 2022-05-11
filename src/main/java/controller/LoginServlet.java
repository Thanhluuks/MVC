package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
					response.sendRedirect("login.jsp");
		    	}
		    	//Get user with account database
		    	ListAccountDAO la = new ListAccountDAO();
		    	if(la.isAvaliable(acc.getUsr(), acc.getPwd())) {
		    		//set session
		    		session.setAttribute("user", user);
		    		//Add cookies to remember
		    		Cookie userCookie = new Cookie("user", user);
		    		Cookie passCookie = new Cookie("password",password);
		    		if(request.getParameter("chkRemember") !=null) {
		    			userCookie.setMaxAge(24 * 60 * 60);
		    			passCookie.setMaxAge(24 * 60 * 60);
		    			
		    		}
		    		else {
		    			userCookie.setMaxAge(0);
		    			passCookie.setMaxAge(0);
		    		}
		    		response.addCookie(userCookie);
		    		response.addCookie(passCookie);
		    		//login valid,now redirect to admin page
		    		response.sendRedirect("index.jsp");
		    	}
		    	else {
		    		session.setAttribute("error","Sai tài khoản hoặc mật khẩu");
		    	
		    		response.sendRedirect("login.jsp");
		    	}
		    }
		    	catch (NullPointerException e){
		    		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		    		rd.forward(request, response);
		    	}
		    	catch (Exception ex) {
		    		response.getWriter().println(ex);
		    	}
		    	
		    
	}

}

