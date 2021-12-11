package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import managers.DocumentManager;
import objects.Course;
import objects.Employee;

public class CourseDAO {
	
//	public static void display(){ 
//		Session session = DocumentManager.getInstance().getFactory().openSession(); 
//		Transaction tx = null; 
//		System.out.println("-------------");
//		try{ 
//			tx = session.beginTransaction(); 
//			Query query= session.createQuery("from Course");
//			List<Course> courses = query.list();
//			for (Course c: courses){ 
//				System.out.println(c); 
//			} 
//			tx.commit(); 
//		}catch (HibernateException e) { 
//			if (tx!=null) tx.rollback(); 
//			e.printStackTrace(); 
//		}finally { 
//			session.close();  
//		}
//	}
	
//	public static List<Course> getCourses() {
//		Session session = DocumentManager.getInstance().getFactory().openSession(); 
//		Transaction tx = null; 
//		try{ 
//			tx = session.beginTransaction(); 
//			Query query= session.createQuery("from Course");
//			List<Course> courses = query.list();
//			tx.commit(); 
//			DocumentManager.getInstance().setCourseList(courses);
//			return courses;
//		}catch (HibernateException e) { 
//			if (tx!=null) tx.rollback(); 
//			e.printStackTrace(); 
//		}finally { 
//			session.close();  
//		}
//		
//		return null;
//	}
//	
////	public static void insert(int idEmployee, String name, int numberOfHours, int value, String graduationDiploma, int year){ 
////		Session session = DocumentManager.getInstance().getFactory().openSession(); 
////		Transaction tx = null; 
////		try{ 
////			tx = session.beginTransaction(); 
////			Employee employee = new Employee();
//	employee.setId(id);
//	employee.setName(name);
//	employee.setFirm(firm);
//	employee.setPosition(position);
//	employee.setDateOfEmployement(date);
//
//	session.update(employee); 
////			tx.commit(); 
////		}catch (HibernateException e) { 
////			if (tx!=null) tx.rollback(); 
////			e.printStackTrace(); 
////		}finally { session.close(); } 
////	}
	
	public static void delete(Integer id){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null;
		try{ 
			tx = session.beginTransaction(); 
			Course c = (Course) session.get(Course.class, id); 
			session.delete(c); 
			tx.commit(); 
		}catch (HibernateException e) { 
			if(tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close(); 
		} 
	}
	
	public static List<Course> getCoursesByName(String name) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			List<Course> courses = new ArrayList<Course>();
			for (Employee e: employees){ 
				Set<Course> set = e.getCourses();
				for(Course c: set) {
					if(c.getName().equals(name)) {
						courses.add(c);
					}
				}
			} 
			tx.commit();
			return courses;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Course> getCoursesByHours(int hours) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			List<Course> courses = new ArrayList<Course>();
			for (Employee e: employees){ 
				Set<Course> set = e.getCourses();
				for(Course c: set) {
					if(c.getNumberOfHours() == hours) {
						courses.add(c);
					}
				}
			} 
			tx.commit();
			return courses;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Course> getCoursesLessThanValue(int value) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			List<Course> courses = new ArrayList<Course>();
			for (Employee e: employees){ 
				Set<Course> set = e.getCourses();
				for(Course c: set) {
					if(c.getValue() < value) {
						courses.add(c);
					}
				}
			} 
			tx.commit();
			return courses;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Course> getCoursesBiggerThanValue(int value) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			List<Course> courses = new ArrayList<Course>();
			for (Employee e: employees){ 
				Set<Course> set = e.getCourses();
				for(Course c: set) {
					if(c.getValue() > value) {
						courses.add(c);
					}
				}
			} 
			tx.commit();
			return courses;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Course> getCourses(){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			List<Course> courses = new ArrayList<Course>();
			
			for (Employee e: employees){ 
				Set<Course> set = e.getCourses();
				for(Course c: set) {
					courses.add(c);
				}
			} 
			DocumentManager.getInstance().setCourseList(courses);
			tx.commit();
			return courses;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		return null;
	}
	
	public static void deleteCourse(int id) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Course");
			List<Course> courses = query.list();
			
			for (Course c: courses){ 
				if(c.getIdCourse() == id) {
					session.delete(c);
					break;
				}
			} 
			tx.commit();
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
	}
	
	public static void insert(int idEmployee, String name, int numberOfHours, int value, String graduationDiploma, int year, Employee person){ 
	Session session = DocumentManager.getInstance().getFactory().openSession(); 
	Transaction tx = null; 
	try{ 
		tx = session.beginTransaction(); 
		Course course = new Course(name, numberOfHours, value, graduationDiploma, year, person); 
		session.save(course); 
		tx.commit(); 
	}catch (HibernateException e) { 
		if (tx!=null) tx.rollback(); 
		e.printStackTrace(); 
	}finally { session.close(); } 
	}

	public static void update(int idCourse, String name, int numberOfHours, int value, String graduationDiploma, int year, Employee perso){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Course course = new Course();
			course.setName(name);
			course.setNumberOfHours(numberOfHours);
			course.setValue(value);
			course.setGraduationDiploma(graduationDiploma);
			course.setYear(2021);
			course.setIdCourse(idCourse);
			course.setEmployee(perso);

			session.update(course); 
			tx.commit(); 
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { session.close(); } 
	}
}
