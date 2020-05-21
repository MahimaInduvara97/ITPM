package com.itpmweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("selectFactor");
		String code = request.getParameter("code");
		
		HttpSession session = request.getSession();
		session.setAttribute("test_code",code);
		
		 if(type.equals("inheritance")) {
			String Inheritance = request.getParameter("Inheritance");
			session.setAttribute("Inheritance",Inheritance);
			String Inheritance1 = request.getParameter("Inheritance1");
			session.setAttribute("Inheritance1",Inheritance1);
			String Inheritance2 = request.getParameter("Inheritance2");
			session.setAttribute("Inheritance2",Inheritance2);
			String Inheritance3 = request.getParameter("Inheritance3");
			session.setAttribute("Inheritance3",Inheritance3);
			String Inheritance4 = request.getParameter("Inheritance4");
			session.setAttribute("Inheritance4",Inheritance4);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/InheritanceTable.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("");
			dispatcher.forward(request, response);
		}
		
	}

}
