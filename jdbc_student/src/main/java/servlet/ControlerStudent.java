package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.StudentDao;
import entity.Student;

/**
 * Servlet implementation class ControlerStudent
 */
@WebServlet({"/ControlerStudent", "/insert", "/delete", "/load", "/update", "/search"})
public class ControlerStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDao studentDao;
	
	@Resource(name = "jdbc/student_web")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		studentDao = new StudentDao(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				addStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;	
			case "/load":
				loadStudent(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			case "/search":
				searchStudent(request, response);
				break;

			default:
				listStudent(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("students", studentDao.getAllStudent());
		request.getRequestDispatcher("/list-student.jsp").forward(request, response);
	}
	
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String languages[] = request.getParameterValues("language");
		
		String language ="";
		
		for(String s : languages) {
			language += s+", ";
		}
		
		Student student = new Student(firstName, lastName, gender, country, language.trim());
		
		if(studentDao.addStudent(student))
			listStudent(request, response);
	}
	
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if(studentDao.deleteStudent(id));
			listStudent(request, response);
	}
	
	public void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", studentDao.getStudent(id));
		request.getRequestDispatcher("/student-form.jsp").forward(request, response);
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String languages[] = request.getParameterValues("language");
		
		String language ="";
		
		for(String s : languages) {
			language += s+", ";
		}
		
		Student student = new Student(id ,firstName, lastName, gender, country, language.trim());

		if(studentDao.updateStudent(student))
			listStudent(request, response);
	}
	
	public void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("students", studentDao.getNameStudents(request.getParameter("nameStudent")));
		request.getRequestDispatcher("/list-student.jsp").forward(request, response);
	}
}
