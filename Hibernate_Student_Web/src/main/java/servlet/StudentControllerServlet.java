package servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.StudentImpl;
import entity.Student;
import services.StudentDao;

/**
 * Servlet implementation class StudentControllerServlet
 */
@MultipartConfig
@WebServlet("/")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	private String id = null;

	public StudentControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		studentDao = new StudentImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		try {
			switch (action) {

			case "/delete":
				deleteStudent(request, response);
				break;
			case "/load":
				id = request.getParameter("id");
				loadStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {

			case "/insert":
				addStudent(request, response);
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

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Student> lsStudents = new ArrayList<Student>();

		lsStudents = studentDao.getAllStudent();

		request.setAttribute("list_Student", lsStudents);

		request.getRequestDispatcher("/list-student.jsp").forward(request, response);

	}

	private boolean checkId(String idRandom) {
		List<Student> students = studentDao.getAllStudent();
		for (Student student : students) {
			if (student.getId().toString().equalsIgnoreCase(idRandom)) {
				System.out.println("error");
				return false;
			}
		}
		return true;
	}

	private String randomId() {
		String id = String.valueOf(UUID.randomUUID());
		while (!checkId(id)) {
			id = String.valueOf(UUID.randomUUID());
		}
		return id;
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = randomId();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
//		Part imagePart = request.getPart("image");
//		String image = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();

		String image = null;
		Student student = new Student(id, firstName, lastName, email, image);

		studentDao.addStudent(student);
		listStudent(request, response);

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		if (studentDao.deleteStudent(id))
			listStudent(request, response);

	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Student student = new Student();
		student = studentDao.getStudent(id);

		request.setAttribute("Student", student);

		request.getRequestDispatcher("/update-student.jsp").forward(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
//		Part imagePart = request.getPart("image");
//		String image = Path.of(imagePart.getSubmittedFileName()).getFileName().toString();
		String image = null;
		Student student = new Student(id, firstName, lastName, email, image);

		studentDao.updateStudent(student);
		listStudent(request, response);
	}

}
