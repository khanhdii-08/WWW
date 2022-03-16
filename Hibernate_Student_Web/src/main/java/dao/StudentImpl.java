package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Student;
import services.StudentDao;
import util.HibernateUtil;

public class StudentImpl implements StudentDao{

	private SessionFactory sessionFactory;
	
	public StudentImpl() {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}
	
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<Student> lsStudent = new ArrayList<Student>();
		String sql = "select * from Student";
		try {
			tr.begin();
			lsStudent = session.createNativeQuery(sql, Student.class).getResultList();
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return lsStudent;
	}

	@Override
	public boolean addStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(student);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean deleteStudent(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.delete(session.find(Student.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(student);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public Student getStudent(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		Student student = new Student();
		try {
			tr.begin();
			student = session.find(Student.class, id);
			tr.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return student;
	}

}
