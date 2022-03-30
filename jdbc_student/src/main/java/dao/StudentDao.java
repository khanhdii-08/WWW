package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public List<Student> getAllStudent(){
		List<Student> ls = new ArrayList<Student>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from Student";
		
		try {
			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String gender = rs.getString("gender");
				String country = rs.getString("country");
				String language = rs.getString("language");
				
				Student student = new Student(id, firstName, lastName, gender, country, language);
				ls.add(student);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ls;
	}
	
	public boolean addStudent(Student student) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "insert Student(firstName, lastName, gender, country, language) values(?, ?, ?, ?, ?)";
		int n =0;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getGender());
			stmt.setString(4, student.getCountry());
			stmt.setString(5, student.getLanguage());
			n=stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return n>0;
	}
	
	public boolean deleteStudent(int id) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql ="delete from Student where id = ?";
		int n=0;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public Student getStudent(int id) {
		
		Student student = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from Student where id = ?";
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String gender = rs.getString("gender");
				String country = rs.getString("country");
				String language = rs.getString("language");
				
				student = new Student( rs.getInt("id"), firstName, lastName, gender, country, language);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public boolean updateStudent(Student student) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sql = "update Student set firstName =?, lastName =?, gender=?, country=?, language=? where id =?";
		int n =0;
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getGender());
			stmt.setString(4, student.getCountry());
			stmt.setString(5, student.getLanguage());
			stmt.setInt(6, student.getId());
			n=stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	public List<Student> getNameStudents(String firstName) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql ="select * from Student where firstName = ?";
		List<Student> ls = new ArrayList<Student>();
		try {
			con = dataSource.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, firstName);
			rs = stmt.executeQuery();
			while (rs.next()) {
				String lastName = rs.getString("lastName");
				String gender = rs.getString("gender");
				String country = rs.getString("country");
				String language = rs.getString("language");
				
				Student student = new Student( rs.getInt("id"), rs.getString("firstName"), lastName, gender, country, language);
				
				ls.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}
