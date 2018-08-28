package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StudentBean;
import com.javatpoint.beans.TeacherBean;
import com.javatpoint.dao.AdminDao;

/**
 * Servlet implementation class AddTeacherRecord
 */
@WebServlet("/AddTeacherRecord")
public class AddTeacherRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add Teacher</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		TeacherBean bean=new TeacherBean(id,name,subject,email,password,address);
		AdminDao.addTeacherRecord(bean);
		out.print("<h4>Teacher added successfully</h4>");
		request.getRequestDispatcher("addteacherrecord.html").include(request, response);				
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
