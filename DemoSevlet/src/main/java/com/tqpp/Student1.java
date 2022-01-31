package com.tqpp;

import java.sql.Date;

public class Student1{
	
	 private int sid,percent;
	 private String sname,city;
	private Date birthdate;
	
	public Student1() {}

	public Student1(int sid, int percent, String sname, String city, Date birthdate) {
		this.sid = sid;
		this.percent = percent;
		this.sname = sname;
		this.city = city;
		this.birthdate = birthdate;
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String toString() {
		return "Student [sid=" + sid + ", percent=" + percent + ", sname=" + sname + ", city=" + city + ", birthdate="
				+ birthdate + "]";
	}
	
}