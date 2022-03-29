package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.Student;

public class StudentDao {
	private DataSource dataSource;

	public StudentDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public List<Student> getAllDao(){
		List<Student> students = new ArrayList<Student>();
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from Student";
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public boolean addStudent(Student student) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String sql = "insert Student(firstName, lastName, email) values(?, ?, ?)";
		int n =0;
	
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			n = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n>0 ;	
	}
	
	public boolean deleteStudent(int id) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String sql = "delete from student where id=?";
		int n=0;
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			n= preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public Student getStudent(int id) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		String sql = "select * from Student where id = ?";
		Student student = null;
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
	
	public boolean updateStudent(Student student) {
		Connection con = null;
		PreparedStatement preparedStatement = null;
		String sql = "update Student set firstName = ?, lastName = ?, email = ? where id = ?";
		int n =0;
		System.out.println(student);
		try {
			con = dataSource.getConnection();
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setInt(4, student.getId());
			n=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
}
