package services;

import java.util.List;

import entity.Student;

public interface StudentDao {
	public List<Student> getAllStudent();
	public boolean addStudent(Student student);
	public boolean deleteStudent(String id);
	public boolean updateStudent(Student student);
	public Student getStudent(String id);
}
