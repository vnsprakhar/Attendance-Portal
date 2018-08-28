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
import com.javatpoint.dao.AdminDao;
import com.javatpoint.dao.StudentDao;

/**
 * Servlet implementation class ViewStudentRecord
 */
@WebServlet("/ViewStudentRecord")
public class ViewStudentRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentRecord() {
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
		out.println("<title>View Student</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		
		List<StudentBean> list=AdminDao.viewStudent();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Course</th><th>Branch</th><th>Year</th><th>Phone</th><th>Email</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
		for(StudentBean bean:list){
			out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getCourse()+"</td><td>"+bean.getBranch()+"</td><td>"+bean.getYear()+"</td><td>"+bean.getPhone()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td><a href='EditLibrarianForm?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteStudent?id="+bean.getId()+"'>Delete</a></td></tr>");
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
