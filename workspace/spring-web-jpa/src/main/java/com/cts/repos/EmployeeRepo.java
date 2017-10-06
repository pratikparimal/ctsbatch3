package com.cts.repos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Employee;

@Repository
public class EmployeeRepo {
	
	
	Logger logger = Logger.getLogger(getClass());
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void addEmployee(Employee employee) {
		//DB operations
		em.persist(employee);
		
	}
	@Transactional
	public List<Employee> findEmployees() {
		Query query = em.createNamedQuery("findAllEmployees");
		List<Employee> employees = query.getResultList();
		System.out.println(employees);
		
		
		return employees;
	}
	
	
	public Employee findEmployee(int id) {
		Employee emp = em.find(Employee.class, id);
		logger.debug(emp);
		return emp;
	}

}
