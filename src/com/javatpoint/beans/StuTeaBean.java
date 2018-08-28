package com.javatpoint.beans;

import java.util.Date;

public class StuTeaBean {
	private int sid,tid;
	
	private String date,attendance,assignment;
	public StuTeaBean(){}
	public StuTeaBean(int sid, int tid, String date, String attendance,
			String assignment) {
		this.sid = sid;
		this.tid = tid;
		this.date = date;
		this.attendance = attendance;
		this.assignment = assignment;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	

}
