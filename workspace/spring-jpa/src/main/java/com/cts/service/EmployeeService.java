package com.cts.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Employee;
import com.cts.entity.Increment;
import com.cts.repos.EmployeeRepo;

@Service
public class EmployeeService {
	
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
	public Employee findEmployee(int id) {
		Employee emp = repo.findEmployee(id);
		System.out.println(emp);
		return emp;
	}

	@Transactional
	public Employee applyIncrement(int id, Increment newIncrement) {
		Employee emp = repo.findEmployee(id);
		newIncrement.setEmployee(emp);
		
		emp.setSalary(emp.getSalary()+newIncrement.getAmount());
		
		Set<Increment> increments = emp.getIncrements();
		increments.add(newIncrement);
		
		return emp;
	}

}
