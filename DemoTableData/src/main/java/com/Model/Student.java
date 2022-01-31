package com.Model;

import java.sql.Date;

public class Student {
	private int sid;
	private String sname;
	private int percent;
	private Date birthdate;
	private String city;
	
	public Student() {
	}

	
	public Student(int sid, String sname, int percent, String city) {
		this.sid = sid;
		this.sname = sname;
		this.percent = percent;
		this.city = city;
	}


	public Student(int sid, String sname, int percent, Date birthdate, String city) {
		this.sid = sid;
		this.sname = sname;
		this.percent = percent;
		this.birthdate = birthdate;
		this.city = city;
	}

	
	
	public Student(String sname, int percent, Date birthdate, String city) {
		this.sname = sname;
		this.percent = percent;
		this.birthdate = birthdate;
		this.city = city;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", percent=" + percent + ", birthdate=" + birthdate
				+ ", city=" + city + "]";
	}
}
