package app;

import dao.StudentImpl;
import services.StudentDao;

public class App {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentImpl();
		
		studentDao.deleteStudent("1");
	}
}
