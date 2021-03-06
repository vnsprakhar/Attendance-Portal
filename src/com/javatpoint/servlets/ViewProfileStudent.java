package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javatpoint.beans.StudentBean;
import com.javatpoint.beans.TeacherBean;
import com.javatpoint.dao.StudentDao;
import com.javatpoint.dao.TeacherDao;

/**
 * Servlet implementation class ViewProfileStudent
 */
@WebServlet("/ViewProfileStudent")
public class ViewProfileStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProfileStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		
		StudentBean tb = StudentDao.viewProfile(email);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>My Profile</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id:</th><td>"+tb.getId()+"</td></tr>");
		out.println("<tr><th>Name:</th><td>"+tb.getName()+"</td></tr>");
		out.println("<tr><th>Course:</th><td>"+tb.getCourse()+"</td></tr>");
		out.println("<tr><th>Branch:</th><td>"+tb.getBranch()+"</td></tr>");
		out.println("<tr><th>Year:</th><td>"+tb.getYear()+"</td></tr>");
		out.println("<tr><th>Phone:</th><td>"+tb.getPhone()+"</td></tr>");
		out.println("<tr><th>Email:</th><td>"+tb.getEmail()+"</td></tr>");
		out.println("<tr><th>Password:</th><td>"+tb.getPassword()+"</td></tr>");
		out.println("</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
