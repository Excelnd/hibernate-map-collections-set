package com.ihs2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihs2code.hibernate.entity.Status;
import com.ihs2code.hibernate.entity.Student;

public class CreateStudentDm {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the object	
			Student tempStudent1  = new Student("John", "Doe", "john@ihs2code.com", Status.ACTIVE);
			Student tempStudent2  = new Student("Ihs", "Public", "ihs@ihs2code.com", Status.INACTIVE);
		
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the student... ");
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!");
						
		}
		finally {
			// clean up code
			session.close();
			factory.close();
		}

	}

}
