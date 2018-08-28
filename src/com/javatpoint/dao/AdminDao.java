package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.StuTeaBean;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.beans.TeacherBean;

public class AdminDao {
	public static int deleteStuRecord(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Student where sid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static int deleteTeaRecord(int id){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("delete from Teacher where tid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int addStudentRecord(StudentBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Student(sid,sname,course,branch,year,phone_no,s_email,s_password) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,bean.getId());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getCourse());
			ps.setString(4,bean.getBranch());
			ps.setInt(5,bean.getYear());
			ps.setInt(6,bean.getPhone());
			ps.setString(7,bean.getEmail());
			ps.setString(8,bean.getPassword());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static int addTeacherRecord(TeacherBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Teacher(tid,tname,sub,t_email,t_password,address) values(?,?,?,?,?,?)");
			ps.setInt(1,bean.getId());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getSub());
			ps.setString(4,bean.getEmail());
			ps.setString(5,bean.getPassword());
			ps.setString(6,bean.getAddress());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	
	public static int updateStudentDetails(StudentBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update Student set sname=?,course=?,branch=?,year=?,phone_no=?,s_email=?,s_password=? where sid=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getCourse()); 
			ps.setString(3,bean.getBranch());
			ps.setInt(4,bean.getYear());
			ps.setInt(5,bean.getPhone());
			ps.setString(6,bean.getEmail());
			ps.setString(7,bean.getPassword());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int updateTeacherDetails(TeacherBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("update Teacher set tname=?,sub=?,t_email=?,t_password=?,address=? where tid=?");
			ps.setString(1,bean.getName());
			ps.setString(2,bean.getSub()); 
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getPassword());
			ps.setString(5,bean.getAddress());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}
	public static int addStuTeaRecord(StuTeaBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into StuTea(sid,tid,date1,attendance,assignment) values(?,?,?,?,?)");
			ps.setInt(1,bean.getSid());
			ps.setInt(2,bean.getTid());
			ps.setString(3,bean.getDate());
			ps.setString(4,bean.getAttendance());
			ps.setString(5,bean.getAssignment());
			status=ps.executeUpdate();
			con.close();
			
		}
		catch(Exception e){System.out.println(e);
		}
		
		return status;
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
	public static List<TeacherBean> viewTeacher(){
		List<TeacherBean> list=new ArrayList<TeacherBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Teacher");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				TeacherBean bean=new TeacherBean();
				bean.setId(rs.getInt("tid"));
				bean.setName(rs.getString("tname"));
				bean.setSub(rs.getString("sub"));
				bean.setEmail(rs.getString("t_email"));
				bean.setPassword(rs.getString("t_password"));
				bean.setAddress(rs.getString("address"));
				list.add(bean);
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return list;
	}
}
