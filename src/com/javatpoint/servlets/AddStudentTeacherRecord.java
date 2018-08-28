package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StuTeaBean;
import com.javatpoint.beans.TeacherBean;
import com.javatpoint.dao.AdminDao;

/**
 * Servlet implementation class AddStudentTeacherRecord
 */
@WebServlet("/AddStudentTeacherRecord")
public class AddStudentTeacherRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentTeacherRecord() {
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
		out.println("<title>Add Table details</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		int sid=Integer.parseInt(request.getParameter("sid"));
		int tid=Integer.parseInt(request.getParameter("tid"));
		String startdate=request.getParameter("date");
	
		String attendance=request.getParameter("attendance");
		String assignment=request.getParameter("assignment");
		StuTeaBean bean=new StuTeaBean(sid,tid,startdate,attendance,assignment);
		AdminDao.addStuTeaRecord(bean);
		out.print("<h4>Record added successfully</h4>");
		request.getRequestDispatcher("updatestudentteacherrecord.html").include(request, response);				
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
