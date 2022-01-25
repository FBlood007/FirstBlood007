package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Configuration.DBconnection;
import com.Model.Student;


public class StudentDaoImplementation implements StudentDao{
	
	private static final String STUDENT_INSERT_SQL="insert into student(sname,percent,birthdate,city) values(?,?,?,?)";
	private static final String FETCH_STUDENTS_SQL="select * from student";
	private static final String DELETE_STUDENT_SQL="delete from student where sid=?";
	private static final String UPDATE_STUDENT_SQL="update student set sname=?,percent=?,birthdate=?,city=? where sid=?";
	private static final String GET_STUDENT_SQL="select * from student where sid=?";
	
	public boolean insertStudent(Student s) {
		try (Connection con = DBconnection.getConnection();
				PreparedStatement p = con.prepareStatement(STUDENT_INSERT_SQL)){
			p.setString(1,s.getSname());
			p.setInt(2,s.getPercent());
			//java.util.Date bdate=s.getBirthdate();
			//Date bd = new Date(bdate.getTime());
			p.setDate(3,s.getBirthdate());
			p.setString(4,s.getCity());
			p.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudentById(int sid) {
		try(Connection con=DBconnection.getConnection();
		PreparedStatement p = con.prepareStatement(DELETE_STUDENT_SQL)	) {
			
			p.setInt(1,sid);
			p.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateStudent(Student s) {
		try(Connection con = DBconnection.getConnection();
			PreparedStatement p = con.prepareStatement(UPDATE_STUDENT_SQL)){
			p.setString(1, s.getSname());
			p.setInt(2, s.getPercent());
			p.setDate(3, s.getBirthdate());
			p.setString(4, s.getCity());
			p.setInt(5, s.getSid());
			p.executeUpdate();
			return true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	public List<Student> getAllStudents() {
		try(Connection con = DBconnection.getConnection();
			Statement st = con.createStatement();	)
		{
			ResultSet r = st.executeQuery(FETCH_STUDENTS_SQL);
			ArrayList<Student> sList = new ArrayList<Student>();
			while(r.next()) {
				Student stu = new Student();
				stu.setSid(r.getInt("sid"));
				stu.setSname(r.getString("sname"));
				stu.setPercent(r.getInt(3));
				stu.setBirthdate(r.getDate(4));
				stu.setCity(r.getString(5));
				sList.add(stu);				
			}
		return sList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Student getStudentById(int sid) {
		try(Connection con = DBconnection.getConnection();
			PreparedStatement p = con.prepareStatement(GET_STUDENT_SQL))
		{
			p.setInt(1, sid);
			ResultSet s = p.executeQuery();
			Student s1 = new Student();
			while(s.next()) {
				s1.setSid(s.getInt(1));
				s1.setSname(s.getString(2));
				s1.setPercent(s.getInt(3));
				s1.setBirthdate(s.getDate(4));
				s1.setCity(s.getString(5));
			}
			return s1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		
	}

	

}
