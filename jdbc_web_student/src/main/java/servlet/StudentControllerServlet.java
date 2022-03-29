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


@WebServlet({"/StudentControllerServlet", "/insert", "/delete", "/load", "/update"})
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private StudentDao studentDao;
	@Resource(name = "jdbc/web_student")
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
			default:
				listStudent(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("students", studentDao.getAllDao());
		request.getRequestDispatcher("/list-student.jsp").forward(request, response);
	}
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student(request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"));
		if(studentDao.addStudent(student))
			listStudent(request, response);
			
	}
	
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		if(studentDao.deleteStudent(id))
			listStudent(request, response);
	}
	
	public void loadStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("student", studentDao.getStudent(id));
		request.getRequestDispatcher("/student-form.jsp").forward(request, response);
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student(Integer.parseInt(request.getParameter("id")), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("email"));
		if(studentDao.updateStudent(student))
			listStudent(request, response);
	}

}
