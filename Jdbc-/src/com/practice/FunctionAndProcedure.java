package com.practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class FunctionAndProcedure {
	Connection con;
	Statement s;
	PreparedStatement p;
	
	public FunctionAndProcedure() {
		con = DBconnection.getConnection();
	}
	public void callStoredProcedure(int a) throws SQLException {
		String s = "call checkPrimeOrComposite(?,?,?)";
		
		CallableStatement c = con.prepareCall(s);
		c.setInt(1, a);
	    c.registerOutParameter(2, Types.INTEGER);
	    c.registerOutParameter(3, Types.VARCHAR);
	    c.execute();
	    String s1 = c.getString(3);
	    int i = c.getInt(2);	
	    System.out.println("Number "+i +" is "+s1);
	}
	public void callFunction(int i) throws SQLException {
		String s = "{?=call discountCost(?)}";
		CallableStatement c = con.prepareCall(s);
		c.registerOutParameter(1, Types.FLOAT);
		c.setInt(2,i);
		c.execute();
		float amount = c.getFloat(1);
		System.out.println("For Cost "+i+" Discount amount is Rs."+ amount);
		
	}
	public static void main(String[] args) throws SQLException {
		FunctionAndProcedure f = new FunctionAndProcedure();
        f.callStoredProcedure(5);
        f.callFunction(688);
    	f.con.close();
	}

}
