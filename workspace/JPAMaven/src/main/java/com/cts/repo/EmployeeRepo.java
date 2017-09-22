package com.cts.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
//			
//			emp.setCity("Delhi");
			
//			em.remove(emp);
		tx.commit();
		em.close();
//		emp.setSalary(44444);
		System.out.println(emp);
		return emp;
	}


	public List<Employee> fetchEmployees() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
//		"select * from Employee"
			Query query = em.createQuery("select e from Employee e");
			List<Employee> employees = query.getResultList();
		tx.commit();
		em.close();
		return employees;
	}


	public List<Employee> fetchEmployeesBySalaryLessThan(int salary) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
//		"select * from Employee"
			Query query = em.createQuery("select e from Employee e where e.salary<=:sal");
			query.setParameter("sal", salary);
			
			List<Employee> employees = query.getResultList();
		tx.commit();
		em.close();
		return employees;
	}
	


}
