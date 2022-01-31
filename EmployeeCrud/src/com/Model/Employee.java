package com.Model;

public class Employee {
	private int eid;
	private String eName;
	private int eSalary;
	private String eMobile;
	
	public Employee() {}
	
	public Employee(String eName, int eSalary, String eMobile) {
		this.eName = eName;
		this.eSalary = eSalary;
		this.eMobile = eMobile;
	}
	
	public Employee(int eid, String eName, int eSalary, String eMobile) {
		this.eid = eid;
		this.eName = eName;
		this.eSalary = eSalary;
		this.eMobile = eMobile;
	}
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteSalary() {
		return eSalary;
	}

	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}

	public String geteMobile() {
		return eMobile;
	}

	public void seteMobile(String eMobile) {
		this.eMobile = eMobile;
	}
	
	public String toString() {
		return "Employee id= " + eid + "\nName= " + eName + "\nSalary= " + eSalary + "\nMobile= " + eMobile + "\n";
	}

	public static void main(String[] args) {
		
	}

}
