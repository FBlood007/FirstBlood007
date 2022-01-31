package com.Dao;

import java.util.List;

import com.Model.Employee;

//DAO =Data Access Object
public interface EmployeeDao {
	
	boolean insertEmployeeData(Employee e);
	boolean deleteEmployeeById(int eid);
	boolean updateEmplyee(Employee e);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int eid);
	List<Employee> maxSalaryEmployee();
	List<Employee> minSalaryEmployee();
	
	


}
