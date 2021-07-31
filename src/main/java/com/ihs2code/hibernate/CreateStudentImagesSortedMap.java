package com.ihs2code.hibernate;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihs2code.hibernate.entity.Student;

public class CreateStudentImagesSortedMap {

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
			Student tempStudent  = new Student("John", "Doe", "ihs@ihs2code.com");
			Map<String, String> theImages = tempStudent.getImages();
			
			theImages.put("photo1.jpg", "Photo 1");
			theImages.put("photo2.jpg", "Photo 2");
			theImages.put("photo3.jpg", "Photo 3");


			
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the student and Images... ");
			session.persist(tempStudent);
			
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
