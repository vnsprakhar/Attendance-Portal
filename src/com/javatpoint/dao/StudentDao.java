package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.javatpoint.beans.StuTeaBean;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.beans.TeacherBean;

public class StudentDao 
{
	/*
	public static int save(StudentBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Student(sid,sname,course,branch,year) values(?,?,?,?,?)");
			ps.setInt(1,bean.getSid());
			ps.setString(2,bean.getSname());
			ps.setString(3,bean.getCourse());
			ps.setString(4,bean.getBranch());
			ps.setInt(5,bean.getYear());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int update(StudentBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update Student set sid=?,sname=?,course=?,branch=?,year=? where sid=?");
			ps.setInt(1,bean.getSid());
			ps.setString(2,bean.getSname());
			ps.setString(3,bean.getCourse());
			ps.setString(4,bean.getBranch());
			ps.setInt(5,bean.getYear());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static List<StudentBean> view(){
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Student");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentBean bean=new StudentBean();
				bean.setSid(rs.getInt("sid"));
				bean.setSname(rs.getString("sname"));
				bean.setCourse(rs.getString("course"));
				bean.setBranch(rs.getString("branch"));
				bean.setYear(rs.getInt("year"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
	public static StudentBean viewById(int id){
		StudentBean bean=new StudentBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Student where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				bean.setSid(rs.getInt(1));
				bean.setSname(rs.getString(2));
				bean.setCourse(rs.getString(3));
				bean.setBranch(rs.getString(4));
				bean.setYear(rs.getInt(5));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static int delete(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Student where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	*/
	public static List<StuTeaBean> viewMyAttendance(String date,int sid){
		List<StuTeaBean> bean = new ArrayList<>();
		System.out.println(date);
		System.out.println(sid);
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from StuTea where date1=? and sid=?");
			ps.setString(1,date);
			ps.setInt(2,sid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StuTeaBean bea=new StuTeaBean();
				bea.setTid(rs.getInt("tid"));
				bea.setAttendance(rs.getString("attendance"));
				bea.setAssignment(rs.getString("assignment"));
			bean.add(bea);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	
	public static StudentBean viewProfile(String email){
		StudentBean bean = new StudentBean();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Student where s_email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				bean.setId(rs.getInt("sid"));
				bean.setName(rs.getString("sname"));
				bean.setCourse(rs.getString("course"));
				bean.setBranch(rs.getString("branch"));
				bean.setYear(rs.getInt("year"));
				bean.setPhone(rs.getInt("phone_no"));
				bean.setEmail(rs.getString("s_email"));
				bean.setPassword(rs.getString("s_password"));
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return bean;
	}
	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from STUDENT where s_email=? and s_password=?");
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
}
