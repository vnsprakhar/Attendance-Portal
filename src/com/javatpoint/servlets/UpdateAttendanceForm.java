package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.StuTeaBean;
import com.javatpoint.dao.TeacherDao;

/**
 * Servlet implementation class UpdateAttendanceForm
 */
@WebServlet("/UpdateAttendanceForm")
public class UpdateAttendanceForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendanceForm() {
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
		out.println("<title>Update Attendance Form</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navadmin.html").include(request, response);
		out.println("<div class='container'>");
		String sid=request.getParameter("tid");
		int id=Integer.parseInt(sid);
		String date=request.getParameter("date");
		List<StuTeaBean> list=TeacherDao.viewByTidDate(id,date);

		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Student_Id</th><th>Attendance</th><th>Assignment</th><th>Update Attendance</th></tr>");
		for(StuTeaBean bean:list){
			out.println("<tr><td><input type='number' class='form-control' value='"+bean.getSid()+"' name='sid' id='sid' placeholder='Name'/></td><td><input type='text' class='form-control' value='"+bean.getAttendance()+"' name='attendance' id='attendance' placeholder='Name'/></td><td><input type='text' class='form-control' value='"+bean.getAssignment()+"' name='assignment' id='assignment' placeholder='Name'/></td><td><a href='UpdateAttendanceFo?id="+bean.getSid()+" "+bean.getTid()+" "+bean.getDate()+" "+bean.getAttendance()+" "+bean.getAssignment()+"'>Update</a></td></tr>");
		}
		out.println("</table>");
        
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
