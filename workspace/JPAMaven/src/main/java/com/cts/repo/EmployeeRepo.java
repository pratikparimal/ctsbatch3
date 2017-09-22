package com.cts.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;

import com.cts.entity.Employee;

public class EmployeeRepo {



	
//	1. Session factory
//	SessionFactory  sesssionFactory = new Configuration().configure().buildSessionFactory();
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa"); 


	public void insertEmp(Employee emp) {
		
//		2. Create a session from session factory
//		Session session = sesssionFactory.openSession();
		EntityManager em = emf.createEntityManager();
		
//		Transaction tx = session.beginTransaction();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
//		3. save method to insert a record
//			session.save(emp);
			em.persist(emp);
		tx.commit();
		em.close();
	}


	public Employee fetchEmp(int id) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
//		3. save method to insert a record
			Employee emp = em.find(Employee.class, id);
		tx.commit();
		em.close();
		System.out.println(emp);
		return emp;
	}

}
