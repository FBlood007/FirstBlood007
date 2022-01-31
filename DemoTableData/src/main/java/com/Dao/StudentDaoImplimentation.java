package com.Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.Configuration.DBConnection;
import com.Model.Student;

public class StudentDaoImplimentation implements StudentDao {

	private static final String STUDENT_INSERT_SQL = "insert into student(sname,percent,birthdate,city) values(?,?,?,?)";
	private static final String FETCH_STUDENTS_SQL = "select * from student";
	private static final String FETCH_STUDENT_SQL = "select * from student where sid=?";
	private static final String DELETE_STUDENT_SQL = "delete from student where sid=?";
	private static final String UPDATE_STUDENT_SQL="update student set sname=?,percent=?,city=? where sid=?";
	
	
	public boolean insertStudent(Student s) {
		try (Connection con = DBConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(STUDENT_INSERT_SQL)) {
			pst.setString(1, s.getSname());
			pst.setInt(2, s.getPercent());
			pst.setDate(3, s.getBirthdate());
			pst.setString(4, s.getCity());
			pst.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteStudentById(int sid) {
		try (Connection con = DBConnection.getConnection();
				PreparedStatement pst = con.prepareStatement(DELETE_STUDENT_SQL)) {
				pst.setInt(1, sid);
				pst.executeUpdate();
				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;

	}
	public boolean updateStudent(Student s) {
		try(Connection con=DBConnection.getConnection();PreparedStatement pst=con.prepareStatement(UPDATE_STUDENT_SQL))
        {
			pst.setString(1, s.getSname());	
        	pst.setInt(2, s.getPercent());
        	pst.setString(3, s.getCity());
        	pst.setInt(4, s.getSid());
        	pst.executeUpdate();
        	return true;
        	
        	
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
}

	
	public List<Student> getAllStudents() {
		try (Connection con = DBConnection.getConnection(); Statement st = con.createStatement()) {
			ResultSet rs = st.executeQuery(FETCH_STUDENTS_SQL);
			ArrayList<Student> slist = new ArrayList<Student>();
			while (rs.next()) {
				Student s1 = new Student();
				s1.setSid(rs.getInt("sid"));
				s1.setSname(rs.getString("sname"));
				s1.setPercent(rs.getInt(3));
				s1.setBirthdate(rs.getDate(4));
				s1.setCity(rs.getString(5));
				slist.add(s1);

			}
			return slist;

		}catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return null;
	}


	public Student getStudentById(int id) {
			try (Connection con = DBConnection.getConnection();
					PreparedStatement pst = con.prepareStatement(FETCH_STUDENT_SQL)) {
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					Student s1 = new Student();
					s1.setSid(rs.getInt(1));
					s1.setSname(rs.getString(2));
					s1.setPercent(rs.getInt(3));
					s1.setBirthdate(rs.getDate(4));
					s1.setCity(rs.getString(5));
					return s1;
				} 
				else
					return null;

			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return null;
		}


}
