package com.practice;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class ResultSetTypes {
	Connection con;
	ResultSet rs;
	Statement st;
		
	public ResultSetTypes() throws SQLException {
		con = DBconnection.getConnection();
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = st.executeQuery("Select * from employee");
		
	}
	//Method to get details
	public void employeeDetails() throws SQLException {
		rs.beforeFirst();
		System.out.println("----------------------------------------------------------------");
		System.out.println("Id\tName\tJDate\t\tSalary\tDeptId\tsupervisorid");
		System.out.println("----------------------------------------------------------------");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3)+"\t"+rs.getInt(4)
			                           +"\t"+rs.getInt(5)+"\t"+rs.getInt(6) );
		}
		System.out.println("----------------------------------------------------------------");
	}
	//Method will give data in reverse order
	public void empDetailsReverseOrder() throws SQLException {
		System.out.println("!!!!!......EMPLOYEE DETAILS IN REVERSE ORDER......!!!!!	");
		System.out.println("----------------------------------------------------------------");
		System.out.println("Id\tName\tJDate\t\tSalary\tDeptId\tsupervisorid");
		System.out.println("----------------------------------------------------------------");
		rs.afterLast();
		while(rs.previous()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3)+"\t"+rs.getInt(4)
			                           +"\t"+rs.getInt(5)+"\t"+rs.getInt(6) );
		}
		System.out.println("----------------------------------------------------------------");
	}
	
	//to get first and last record in table
	public void firstAndLastRecord() throws SQLException {
		System.out.println("----------------------------------------------------------------");
		System.out.println("Id\tName\tJDate\t\tSalary\tDeptId\tsupervisorid");
		System.out.println("----------------------------------------------------------------");
		rs.first();//to get first record
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3)+"\t"+rs.getInt(4)
        +"\t"+rs.getInt(5)+"\t"+rs.getInt(6) );
		rs.last();//to get last record
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3)+"\t"+rs.getInt(4)
        +"\t"+rs.getInt(5)+"\t"+rs.getInt(6) );
		System.out.println("----------------------------------------------------------------");
		
	}
	//Method to make updation 
	public void salaryRevision(int empid,int salary) throws SQLException {
		rs.beforeFirst();
		while(rs.next()) {
			if(rs.getInt(1)==empid) {
				rs.updateInt(4,salary);
				rs.updateRow();
			}
		}
		System.out.println("Updation done Successfull..!!");
	}
	//to remove record on certain row
	public void removeRecord(int recordNo) throws SQLException {
		rs.absolute(recordNo);	
		rs.deleteRow();
		System.out.println("\nRecord Deleted Successfully");
	}
	
	//Method to insert record in table
	public void insertNewRecord(int id,String name,Date date,int sal,int dId,int sId) throws SQLException {
		
		rs.moveToInsertRow();
		rs.updateInt(1,id);
		rs.updateString(2,name);
		rs.updateDate(3, date);
		rs.updateInt(4, sal);
		rs.updateInt(5, dId);
		rs.updateInt(6, sId);
		rs.insertRow();
		System.out.println("\nNew Row Added");
		
	}
	public static void main(String[] args) throws SQLException {
		ResultSetTypes r = new ResultSetTypes();
		r.employeeDetails();
		//r.empDetailsReverseOrder();
		//r.firstAndLastRecord();
		
		//r.salaryRevision(107,80500);
		//r.employeeDetails();
		
		//r.insertNewRecord(133, "ABV", Date.valueOf("2020-07-11") , 12341, 2, 101);
		r.employeeDetails();
		
		//r.removeRecord(7);
//		r.employeeDetails();
		
		
		r.con.close();
	}

}
