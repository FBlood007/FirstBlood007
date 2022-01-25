package com.Controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.Dao.StudentDao;
import com.Dao.StudentDaoImplementation;
import com.Model.Student;

public class StudentController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentDao sdao = new StudentDaoImplementation();
		System.out.println("!!****************WELCOME USER****************!!");
		char ch='y';
		do {
			System.out.println("1-Add New Student\n2-Delete Student\n3-Update Student\n4-View all Students\n5-Get Student using Sid");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:System.out.println("***Insert new Student Record***");
					   System.out.println("Enter Name");
					   String nm = sc.next();
					   System.out.println("Enter Precentage");
					   int pre = sc.nextInt();
					   System.out.println("Enter Date of Birth(yyyy-mm-dd)");
					   String d = sc.next();
					   System.out.println("Enter City Name");
					   String c = sc.next();
		
					   Student s1 = new Student(nm,pre,Date.valueOf(d),c);
					   boolean isInsert = sdao.insertStudent(s1);
					   if(isInsert) {
				    	 System.out.println("Record Inserted Successfully\n");
					   }
				       else
					     System.out.println("ERROR! Unsuccessful insertion");
					   break;
					   
				 case 4:
					 System.out.println("*****Student Details*****");
					 List<Student> s = sdao.getAllStudents();
					 for(Student st : s) {
						 System.out.println(st);
					 }
				 	 break;
				 	
				 case 2:
					 System.out.println("Enter the Student id to delete Student data");
					 int id = sc.nextInt();
					 boolean isDelete = sdao.deleteStudentById(id);
					 if(isDelete) {
				    	 System.out.println("Record Deleted Successfully\n");
					   }
				       else
					     System.out.println("ERROR! Unsuccessful deletion");
					 break;
					 
				 case 3:
					 System.out.println("!!********Update in Student data********!!");
					 System.out.println("Enter the Student id you want to update : ");
					 int sid = sc.nextInt();
					 List<Student> l = sdao.getAllStudents();
					 boolean flag=false;
					 for(Student st : l) {
						 if(st.getSid()==sid) 
							 flag=true;
					 }
					 if(flag)
					 {
						 System.out.println("Enter Student Name :");
						 String name=sc.next();
						 System.out.println("Enter percentage :");
						 int pr=sc.nextInt();
						 System.out.println("Enter Birth of Date :");
						 String da = sc.next();
						 System.out.println("Enter city :");
						 String city=sc.next();
						 Student ss = new Student(sid,name,pr,Date.valueOf(da),city);
						 boolean isUpdated=sdao.updateStudent(ss);
						 if(isUpdated) {
					    	 System.out.println("Record Updated Successfully\n");
						   }
					       else
						     System.out.println("ERROR! Unsuccessful Updation");
					 }
					 else {
						 System.out.println("No Student present with id = "+sid+"\n");}
					 break;
					 
				 case 5:
					 System.out.println("Student Details As per ID");
					 System.out.println("Enter Student Id:");
					 int n = sc.nextInt();
					 Student stu = sdao.getStudentById(n);
					 System.out.println(stu);
					 break;
			}
			System.out.println("--------------------------------------------------------------");
			System.out.println("Do you want to continue (Y/N)");
			ch=sc.next().charAt(0);
		} while (ch=='y'||ch=='Y');
		System.out.println("******************THANK YOU******************");

	}

}
