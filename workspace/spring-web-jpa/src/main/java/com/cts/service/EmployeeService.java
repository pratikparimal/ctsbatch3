package com.cts.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Employee;
import com.cts.entity.Increment;
import com.cts.entity.IncrementRequest;
import com.cts.repos.EmployeeRepo;
import com.cts.repos.LogRepo;

@Service
public class EmployeeService {
	
	Logger logger = Logger.getLogger(EmployeeService.class);
	
	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	LogRepo logRepo;

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
		
		logger.warn("Increment is :" + newIncrement);
		
		//Ideally should mock emp object
		Employee emp = repo.findEmployee(id);
//		logger.warn(emp);
//		logger.warn(emp.getIncrements());
		
		//Mocks, JMock, Mockito
		IncrementRequest incrementRequest = new IncrementRequest(emp.getName(), new Date(), newIncrement.getAmount());
		logRepo.logIncrementRequest(incrementRequest);
		
		
		emp.setSalary(emp.getSalary()+newIncrement.getAmount());
		newIncrement.setEmployee(emp);
		Set<Increment> increments = emp.getIncrements();
		logger.warn(increments);
		increments.add(newIncrement);
//		emp.setIncrements(increments);
		
		if(newIncrement.getAmount()==10){
			throw new RuntimeException();
		}
		
		
		return emp;
	}

}
