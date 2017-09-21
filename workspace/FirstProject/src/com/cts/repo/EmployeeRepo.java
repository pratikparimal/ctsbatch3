package com.cts.repo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cts.entity.Employee;

public class EmployeeRepo {



	
//	1. Session factory
	SessionFactory  sesssionFactory = new Configuration().configure().buildSessionFactory();
	
	
	public void insertEmp(Employee emp) {
//		2. Create a session from session factory
		Session session = sesssionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		3. save method to insert a record
			session.save(emp);
		tx.commit();
		session.close();
	}


	public Employee fetchEmp(int id) {
		Session session = sesssionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		3. save method to insert a record
			Employee emp = (Employee) session.get(Employee.class, id);
		tx.commit();
		session.close();
		System.out.println(emp);
		return emp;
	}

}
