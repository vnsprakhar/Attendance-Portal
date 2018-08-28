package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StudentBean;
import com.javatpoint.beans.TeacherBean;
import com.javatpoint.dao.AdminDao;

/**
 * Servlet implementation class ViewTeacherRecord
 */
@WebServlet("/ViewTeacherRecord")
public class ViewTeacherRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTeacherRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Teacher</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		List<TeacherBean> list=AdminDao.viewTeacher();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Subject</th><th>Email</th><th>Password</th><th>Address</th><th>Edit</th><th>Delete</th></tr>");
		for(TeacherBean bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getSub()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getAddress()+"</td><td><a href='EditLibrarianForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteTeacher?id="+bean.getId()+"'>Delete</a></td></tr>");
		}
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
