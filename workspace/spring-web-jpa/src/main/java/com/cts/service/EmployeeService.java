package com.cts.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Employee;
import com.cts.entity.Increment;
import com.cts.repos.EmployeeRepo;

@Service
public class EmployeeService {
	
	Logger logger = Logger.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepo repo;

	//Business Logic
	public void addEmployee(Employee employee) {
		
		Set<Increment> increments = employee.getIncrements();
		double totalIncrementAmount = 0;
		for(Increment increment: increments){
			totalIncrementAmount += increment.getAmount();
		}
		employee.setSalary(totalIncrementAmount);
		repo.addEmployee(employee);
		
	}

	public List<Employee> findEmployees() {
		
		return repo.findEmployees();
	}

	@Transactional
	public Employee findEmployee(int id) throws Exception {
//		logger.debug("Id is :" + id);
		if(id<0){
			throw new Exception("Id supplied in not correct");
		}
		Employee emp = repo.findEmployee(id);
		logger.debug("***************");
		logger.debug(emp);
		logger.debug("***************");
		System.out.println(emp);
		return emp;
	}

	@Transactional
	public Employee applyIncrement(int id, Increment newIncrement) {
//		logger.debug("Id is :" + id);
//		logger.debug("Increment is :" + newIncrement);
		Employee emp = repo.findEmployee(id);
		logger.warn(emp);
		logger.warn(emp.getIncrements());
		newIncrement.setEmployee(emp);
		
		emp.setSalary(emp.getSalary()+newIncrement.getAmount());
		
		Set<Increment> increments = emp.getIncrements();
		increments.add(newIncrement);
		emp.setIncrements(increments);
		
		return emp;
	}

}
