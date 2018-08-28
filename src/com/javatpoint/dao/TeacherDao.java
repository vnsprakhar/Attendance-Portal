package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.javatpoint.beans.StudentBean;
import com.javatpoint.beans.StuTeaBean;
import com.javatpoint.beans.TeacherBean;

public class TeacherDao 
{
	
	public static int updateAttendance(StuTeaBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update StuTea set attendance=?,assignment=? where tid=? and sid=? and date1=?");
			ps.setString(1,bean.getAttendance());
			ps.setString(2,bean.getAssignment()); 
			ps.setInt(3,bean.getTid());
			ps.setInt(4,bean.getSid());
			ps.setString(5,bean.getDate());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<StuTeaBean> viewStuAtten(String date,int tid){
		List<StuTeaBean> list=new ArrayList<StuTeaBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from StuTea where date1=? and tid=?");
			ps.setString(1,date);
			ps.setInt(2,tid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StuTeaBean bean=new StuTeaBean();
				bean.setSid(rs.getInt("sid"));
				bean.setAttendance(rs.getString("attendance"));
				bean.setAssignment(rs.getString("assignment"));
				
			list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	
	public static TeacherBean viewProfile(String email){
		TeacherBean bean = new TeacherBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Teacher where T_EMAIL=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
		while(rs.next()){
				bean.setId(rs.getInt("tid"));
				bean.setName(rs.getString("tname"));
				bean.setSub(rs.getString("sub"));
				bean.setEmail(rs.getString("t_email"));
				bean.setPassword(rs.getString("t_password"));

				bean.setAddress(rs.getString("address"));
		}System.out.println("prkhar");
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		System.out.println(bean);
		return bean;
	}
	public static List<StudentBean> viewStudent(){
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentBean bean=new StudentBean();
				bean.setId(rs.getInt("sid"));
				bean.setName(rs.getString("sname"));
				bean.setCourse(rs.getString("course"));
				bean.setBranch(rs.getString("branch"));
				bean.setYear(rs.getInt("year"));
				bean.setPhone(rs.getInt("phone_no"));
				bean.setEmail(rs.getString("s_email"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	

	
	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Teacher where t_email=? and t_password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<StuTeaBean> viewByTidDate(int id,String date){
		List<StuTeaBean> bean=new ArrayList<>();
	//	System.out.println(id);
		//System.out.println(date);
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from StuTea where tid=? and date1=?");
			ps.setInt(1,id);
			ps.setString(2,date);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StuTeaBean be=new StuTeaBean();
				be.setTid(rs.getInt("tid"));
				be.setDate(rs.getString("date1"));
				be.setSid(rs.getInt("sid"));
				be.setAttendance(rs.getString("attendance"));
				be.setAssignment(rs.getString("assignment"));
				bean.add(be);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);
	}
		
		return bean;
	}
	public static StuTeaBean viewBySidDate(int sid,int tid,String date){
	
		StuTeaBean be=new StuTeaBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from StuTea where sid=? and tid=? and date1=?");
			ps.setInt(1,sid);
			ps.setInt(2, tid);
			ps.setString(3,date);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				be.setTid(rs.getInt("tid"));
				be.setDate(rs.getString("date1"));
				be.setSid(rs.getInt("sid"));
				be.setAttendance(rs.getString("attendance"));
				be.setAssignment(rs.getString("assignment"));
				
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);
	}
		
		return be;
	}
}
