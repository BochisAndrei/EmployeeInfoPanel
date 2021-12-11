package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import managers.DocumentManager;
import objects.Course;
import objects.Employee;

public class EmployeeDAO {

	public static final int EMPLOYEE_COLUMNS = 5;
	
	public static void display(){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		System.out.println("-------------");
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			for (Employee e: employees){ 
				System.out.println(e); 
			} 
			tx.commit(); 
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
	}
	
	public static List<Employee> getEmployees() {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee");
			List<Employee> employees = query.list();
			tx.commit(); 
			DocumentManager.getInstance().setEmployeeList(employees);
			return employees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static void insert(String name, String firm, String position, Date date){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Employee b= new Employee(name, firm, position, date); 
			session.save(b); 
			tx.commit(); 
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { session.close(); } 
	}
	
	public static void update(int id, String name, String firm, String position, Date date){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Employee employee = new Employee();
			employee.setId(id);
			employee.setName(name);
			employee.setFirm(firm);
			employee.setPosition(position);
			employee.setDateOfEmployement(date);

			session.update(employee); 
			tx.commit(); 
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { session.close(); } 
	}
	
	
	public static void delete(Integer id){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null;
		try{ 
			tx = session.beginTransaction(); 
			Employee b= (Employee) session.get(Employee.class, id); 
			session.delete(b); 
			tx.commit(); 
		}catch (HibernateException e) { 
			if(tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close(); 
		} 
	}
	
	public static List<Employee> getEmployeesByName(String name) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee E where E.name = :name");
			query.setParameter("name", name);
			List<Employee> employees = query.list();
			tx.commit(); 
			DocumentManager.getInstance().setEmployeeList(employees);
			return employees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static Employee getEmployeesById(int id) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee E where E.id = :id");
			query.setParameter("id", id);
			List<Employee> employees = query.list();
			if(employees.size() > 0) {
				return employees.get(0);
			}
			tx.commit(); 
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Employee> getEmployeesLessThanDate(Date date) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee E where E.dateOfEmployement < :date");
			query.setParameter("date", date);
			List<Employee> employees = query.list();
			tx.commit(); 
			DocumentManager.getInstance().setEmployeeList(employees);
			return employees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Employee> getEmployeesBiggerThanDate(Date date) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee E where E.dateOfEmployement > :date");
			query.setParameter("date", date);
			List<Employee> employees = query.list();
			tx.commit(); 
			DocumentManager.getInstance().setEmployeeList(employees);
			return employees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Employee> getEmployeesByFirm(String firm) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee E where E.firm = :firm");
			query.setParameter("firm", firm);
			List<Employee> employees = query.list();
			tx.commit(); 
			DocumentManager.getInstance().setEmployeeList(employees);
			return employees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Employee> getEmployeesByPosition(String position) {
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee E where E.position = :position");
			query.setParameter("position", position);
			List<Employee> employees = query.list();
			tx.commit(); 
			DocumentManager.getInstance().setEmployeeList(employees);
			return employees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		
		return null;
	}
	
	public static List<Employee> getEmployeesThatMatchCourse(int id){ 
		Session session = DocumentManager.getInstance().getFactory().openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Query query= session.createQuery("from Employee"); //Hibernate Querry Language (HQL)
			List<Employee> employees = query.list();
			List<Employee> tempEmployees = new ArrayList<Employee>();
			
			for (Employee e: employees){ 
				Set<Course> set = e.getCourses();
				for(Course c: set) {
					if(c.getIdCourse() == id) {
						tempEmployees.add(e);
						break;
					}
				}
			} 

			DocumentManager.getInstance().setEmployeeList(tempEmployees);
			tx.commit();
			return tempEmployees;
		}catch (HibernateException e) { 
			if (tx!=null) tx.rollback(); 
			e.printStackTrace(); 
		}finally { 
			session.close();  
		}
		return null;
	}
}
