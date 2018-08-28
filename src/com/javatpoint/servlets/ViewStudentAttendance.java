package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StuTeaBean;
import com.javatpoint.dao.StudentDao;
import com.javatpoint.dao.TeacherDao;

/**
 * Servlet implementation class ViewStudentAttendance
 */
@WebServlet("/ViewStudentAttendance")
public class ViewStudentAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewStudentAttendance() {
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
		out.println("<title>View Student Attendance</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		int id=Integer.parseInt(request.getParameter("tid"));
		String date=request.getParameter("date");
		List<StuTeaBean> list=TeacherDao.viewStuAtten(date,id);
		System.out.println(list);
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><td>StudentId</td>");
		for(StuTeaBean bean:list){
			out.println("<td>"+bean.getSid()+"</td>");
		}
		out.println("</tr><tr><td>Attendance</td>");
		for(StuTeaBean bean:list){
			out.println("<td>"+bean.getAttendance()+"</td>");
		}
		out.println("</tr><tr><td>Assignment</td>");
		for(StuTeaBean bean:list){
			out.println("<td>"+bean.getAssignment()+"</td>");
		}
		out.println("</tr");


		out.println("</table>");
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
