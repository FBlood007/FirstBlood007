package com.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionExample2 {
	
	Connection con;
	ResultSet rs,rs1,rs2;
	Statement st,st1,st2;
	
	HashMap<String,ArrayList<String>> empdptMap ; 
	
	public CollectionExample2() throws SQLException {
		con= DBconnection.getConnection();
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		empdptMap= new HashMap<>();

	}
	public void departmentEmpMap() throws SQLException{
		
		rs1 = st1.executeQuery("select * from department");
		rs2 = st2.executeQuery("select distinct deptid from employee");
		rs = st.executeQuery("select * from employee");
		ArrayList<String> employee;
		String empName = null,deptName= null;
	
		while(rs2.next()) {
			employee = new ArrayList<>();
			rs.beforeFirst();
			rs1.beforeFirst();
			while(rs1.next()) {
				
				if(rs2.getInt(1)==rs1.getInt(1)) {
					deptName=rs1.getString(2);
				}
			}
			while(rs.next()) {
			
				if(rs2.getInt(1)==rs.getInt(5)) {
					empName = rs.getString(2);
					employee.add(empName);
				}
			}
			empdptMap.put(deptName, employee);
			}
		}
	
	public void showEmpDeptMap(){
		
		Set<Entry<String,ArrayList<String>>> s = empdptMap.entrySet();
		for(Entry<String,ArrayList<String>> e : s) {
			System.out.println("Dept ID :"+e.getKey());
			System.out.println("Employees : "+e.getValue());
			System.out.println();
		}
		
	}
	public static void main(String[] args) throws SQLException {
		CollectionExample2 ce = new CollectionExample2();
		ce.departmentEmpMap();
		ce.showEmpDeptMap();
	}
	
}
