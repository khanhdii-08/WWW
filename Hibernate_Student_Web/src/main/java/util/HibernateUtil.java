package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.Student;

public class HibernateUtil {
	private static HibernateUtil instance = new HibernateUtil();
	private SessionFactory factory;
	private HibernateUtil() {
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		Metadata metadata = new MetadataSources(registry)
				.addAnnotatedClass(Student.class)
				.getMetadataBuilder()
				.build();
		factory = metadata.getSessionFactoryBuilder()
				.build();
	}
	
	public static HibernateUtil getInstance() {
		if(instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
	
	public SessionFactory getSessionFactory() {
		return factory;
	}
}
