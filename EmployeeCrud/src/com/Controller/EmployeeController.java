package com.Controller;

import java.util.List;
import java.util.Scanner;

import com.Dao.EmployeeDao;
import com.Dao.EmployeeDaoImplementation;
import com.Model.Employee;



public class EmployeeController {
//	boolean insertEmployeeData(Employee e);
//	boolean deleteEmployeeById(int eid);
//	boolean updateEmplyee(Employee e);
//	List<Employee> getAllEmployee();
//	Employee getEmployeeById(int eid);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeDao edo = new EmployeeDaoImplementation();
		System.out.println("!!********************WELCOME USER**********************!!");
		char ch = 'Y';
		do {
			System.out.println("1-Add New Employee Data\n2-Delete Employee\n3-Update Data in Employee\n4-View all Employees\n5-Get Employee with Employee id\n6-Employee with max salary\n7-Employee with min salary");
			int choice = sc.nextInt();
			System.out.println("----------------------------------------------------------------");
			switch(choice) {
				case 1:
					System.out.println("Insert the Employee Details below:");
					System.out.println("Enter the Employee Id :");
					int id =sc.nextInt();
					System.out.println("Enter Name:");
					String na = sc.next();
					System.out.println("Enter the Salary:");
					int sal = sc.nextInt();
					System.out.println("Enter Mobile Number :");
					String mon = sc.next();
					Employee e = new Employee(id,na,sal,mon);
					boolean isInserted = edo.insertEmployeeData(e);
					if(isInserted) {
						System.out.println("Data Inserted Succcessfully..!!");
					}
					else {
						System.out.println("ERROR !! Data Insertion Unsuccessful");
					}
					break;
				
				case 2:
					System.out.println("Enter Employee Id to delete data :");
					int i = sc.nextInt();
					boolean isDeleted = edo.deleteEmployeeById(i);
					if(isDeleted) {
						System.out.println("Data Deleted Succcessfully..!!");
					}
					else {
						System.out.println("ERROR !! Data Deletion Unsuccessful");
					}
					break;
					
				case 3:
					System.out.println("Enter Employee Id whose Data you want to Update :");
					int eId = sc.nextInt();
					List<Employee> l = edo.getAllEmployee();
					boolean flag = false;
					for(Employee l1 : l) {
						if(l1.getEid()==eId)
							flag= true;	
					}
					if(flag){
						System.out.println("Enter the Name :");
						String name = sc.next();
						System.out.println("Enter Salary :");
						int salary = sc.nextInt();
						System.out.println("Enter Mobile No. :");
						String mobile = sc.next(); 
						Employee e1 = new Employee(eId,name,salary,mobile);
						boolean isUpdated = edo.updateEmplyee(e1);
						if(isUpdated) {
							System.out.println("Data Updated Succcessfully..!!");
						}
						else {
							System.out.println("ERROR !! Data Updation Unsuccessful");
						}
					}
					else{
						System.out.println("There is no such Employee present with Eid = "+eId);}
					break;
					
				case 4:
					System.out.println("Details of Employees:\n");
					List<Employee> le = edo.getAllEmployee();
					le.forEach((o)->System.out.println(o));
					break;
				
				case 5:
					System.out.println("Enter the Employee Id:");
					int eid = sc.nextInt();
					Employee e1 = edo.getEmployeeById(eid);
					if(e1.getEid()!=0)
						System.out.println(e1);
					else
						System.out.println("No such Employee Present");
					break;
				
				case 6:
					System.out.println("Employee With Max Salary:\n");
					List<Employee> eListMax = edo.maxSalaryEmployee();
					eListMax.forEach((o)->System.out.println(o));
					break;
					
				case 7:	
					System.out.println("Employee With Minumum Salary:\n");
					List<Employee> eListMin = edo.minSalaryEmployee();
					eListMin.forEach((o)->System.out.println(o));
					break;
			}
			System.out.println("----------------------------------------------------------------");
			System.out.println("Do you want to Continue ? (Y/N)");
			ch = sc.next().charAt(0);
			System.out.println("----------------------------------------------------------------");
			
		} while (ch=='y'||ch=='Y');
		System.out.println("!!!***********THANK YOU***********!!!");
	}

}
