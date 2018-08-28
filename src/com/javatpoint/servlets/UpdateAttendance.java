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
 * Servlet implementation class UpdateAttendance
 */
@WebServlet("/UpdateAttendance")
public class UpdateAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id1=request.getParameter("tid");
		int tid=Integer.parseInt(id1);
		String date=request.getParameter("date");
		int sid=Integer.parseInt(request.getParameter("sid"));
		String attendance=request.getParameter("attendance");
		String assignment=request.getParameter("assignment");
		StuTeaBean bean=new StuTeaBean(sid,tid,date,attendance,assignment);
		TeacherDao.updateAttendance(bean);
		
		response.sendRedirect("/Attendance_Mangement_System/UpdateAttendanceForm?tid="+tid+"&date="+date+"");
	}

}
