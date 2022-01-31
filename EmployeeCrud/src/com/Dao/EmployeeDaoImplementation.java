package com.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.Configuration.DBconnection;
import com.Model.Employee;

public class EmployeeDaoImplementation implements EmployeeDao{
	public static final String INSERT_EMPLOYEE_SQL="insert into employee values (?,?,?,?)";
	public static final String DELETE_EMPLOYEE_SQL="delete from employee where eid=?";
	public static final String UPDATE_EMPLOYEE_SQL="update employee set eName=?,eSalary=?,eMobile=? where eid=?";
	public static final String FETCH_EMPLOYEE_SQL="select * from employee";
	public static final String EMPLOYEE_BYID_SQL="select * from employee where eid=?";
	
	public boolean insertEmployeeData(Employee e) {
		try(Connection con = DBconnection.getConnection();
			PreparedStatement p = con.prepareStatement(INSERT_EMPLOYEE_SQL)	) {
			p.setInt(1, e.getEid());
			p.setString(2, e.geteName());
			p.setInt(3,e.geteSalary());
			p.setString(4,e.geteMobile());
			p.executeUpdate();
			return true;
			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return false;
	}


	public boolean deleteEmployeeById(int eid) {
		try(Connection con = DBconnection.getConnection();
			PreparedStatement p = con.prepareStatement(DELETE_EMPLOYEE_SQL)	)
		{
			p.setInt(1, eid);
			p.executeUpdate();
			return true;
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return false;
	}


	public boolean updateEmplyee(Employee e) {
		try(Connection con = DBconnection.getConnection();
		PreparedStatement p = con.prepareStatement(UPDATE_EMPLOYEE_SQL))
		{
		
		p.setString(1,e.geteName() );
		p.setInt(2, e.geteSalary());
		p.setString(3, e.geteMobile());
		p.setInt(4, e.getEid());
		p.executeUpdate();
		return true;
		
		}catch(SQLException ee) {
			ee.printStackTrace();
		}
		return false;
	}
	public List<Employee> getAllEmployee() {
		
		try(Connection con=DBconnection.getConnection();
			Statement s = con.createStatement())
		{
			List<Employee> l = new ArrayList<>();
			ResultSet r = s.executeQuery(FETCH_EMPLOYEE_SQL);
			while(r.next()) {
				Employee e1 = new Employee();
				e1.setEid(r.getInt(1));
				e1.seteName(r.getString(2));
				e1.seteSalary(r.getInt(3));
				e1.seteMobile(r.getString(4));
				l.add(e1);
			}
			return l;
		}catch(SQLException e) {		
			e.printStackTrace();
		}

		ArrayList<Employee> e= new ArrayList<>();
		
		return null;
	}
	public Employee getEmployeeById(int eid) {
		try(Connection con = DBconnection.getConnection();
		PreparedStatement  p = con.prepareStatement(EMPLOYEE_BYID_SQL))
		{
			p.setInt(1, eid);
			ResultSet r = p.executeQuery();
			Employee e = new Employee();
			while(r.next()) {
				e.setEid(r.getInt(eid));
				e.seteName(r.getString(2));
				e.seteSalary(r.getInt(3));
				e.seteMobile(r.getString(4));
			}
			return e;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> maxSalaryEmployee() {
		try(Connection con = DBconnection.getConnection();
				CallableStatement c = con.prepareCall("call maxSalary()"))
		{
			ResultSet r = c.executeQuery();
			List<Employee> l1 = new ArrayList<>();
			while (r.next()){
				Employee e = new Employee();
				e.setEid(r.getInt(1));
				e.seteName(r.getString(2));
				e.seteSalary(r.getInt(3));
				e.seteMobile(r.getString(4));
				l1.add(e);
			}
			return l1;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}

	public List<Employee> minSalaryEmployee() {
		try(Connection con=DBconnection.getConnection();
				CallableStatement c = con.prepareCall("call minSalary()"))
		{
			ResultSet r = c.executeQuery();
			List<Employee> l = new ArrayList<>();
			while (r.next()){
				Employee e = new Employee();
				e.setEid(r.getInt(1));
				e.seteName(r.getString(2));
				e.seteSalary(r.getInt(3));
				e.seteMobile(r.getString(4));
				l.add(e);
			}
			return l;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		
	}



}
