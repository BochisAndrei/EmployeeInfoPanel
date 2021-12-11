package launch;

import java.awt.EventQueue;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import managers.DocumentManager;
import objects.Course;
import objects.Employee;
import windowbuilder.Gui;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		initializeDatabase();
		launchGui();
	}

	private static void launchGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Gui();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void initializeDatabase() {
		try{ 
			Configuration configuration = new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Course.class);
			
			StandardServiceRegistry service = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			DocumentManager.getInstance().setFactory(configuration.buildSessionFactory(service));
		}
		catch(Throwable ex){
			System.err.println("Problems creating object factory..." + ex); 
			throw new ExceptionInInitializerError(ex);
		}
	}
}
