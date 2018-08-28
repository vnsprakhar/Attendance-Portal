package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateAttendanceFo
 */
@WebServlet("/UpdateAttendanceFo")
public class UpdateAttendanceFo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendanceFo() {
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
		out.println("<title>Update Attendance</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");

		String s[]=request.getParameter("id").split(" ");
		int sid=Integer.parseInt(s[0]);
		int tid=Integer.parseInt(s[1]);
		String date=s[2];
		//StuTeaBean bean=TeacherDao.viewById(id);
		
		out.print("<form action='UpdateAttendance' method='post' style='width:300px'>");
		out.print("<div class='form-group'>");
		out.print("<input type='hidden' name='tid' value='"+tid+"'/>");
		out.print("<input type='hidden' name='date' value='"+date+"'/>");
		out.print("<label for='name1'>Student_ID</label>");
		out.print("<input type='number' name='sid' value='"+sid+"'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='attendance'>Attendance</label>");
		out.print("<input type='text' class='form-control' name='attendance' id='attendance' placeholder='attendance'/>");
		out.print("</div>");
		out.print("<div class='form-group'>");
		out.print("<label for='assignment'>Assignment</label>");
		out.print("<input type='text' class='form-control' name='assignment' id='assignment' placeholder='assignment'/>");
		out.print("</div>");
		out.print("<button type='submit' class='btn btn-primary'>Update</button>");
		out.print("</form>");
		
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
