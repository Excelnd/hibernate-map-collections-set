package com.ihs2code.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ihs2code.hibernate.entity.Address;
import com.ihs2code.hibernate.entity.Student;

public class CreateStudentAddress {

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

			// create the address object
			Address billingAddress = new Address("Some Billing street", "Some Billing City", "56321496");
			
			// start a transaction
			session.beginTransaction();
			
			// save the object
			System.out.println("Saving the student and Images... ");
			tempStudent.setBillingAddress(billingAddress);
			session.save(tempStudent);
			
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
