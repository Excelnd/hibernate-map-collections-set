package com.ihs2code.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihs2code.hibernate.entity.Student;

public class CreateStudentImagesList {

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
			List<String> theImages = tempStudent.getImages();
			
			theImages.add("photo1.jpg"); // duplicate, filtered at HashSet
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo5.jpg");

			
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
