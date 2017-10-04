package com.cts;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.Employee;
import com.cts.entity.Increment;
import com.cts.service.EmployeeService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestEmployeeIncrement {
	
	Logger logger = Logger.getLogger(TestEmployeeIncrement.class);
	
	@Autowired
	EmployeeService service;

//	@Test
	public void testAddEmployee() {
		
		Employee employee = new Employee("Arun", 0);
		
		Increment increment1 = new Increment(new Date(), 20000);
		increment1.setEmployee(employee);
		
		Set<Increment> increments = new HashSet<>();
		increments.add(increment1);
		
		employee.setIncrements(increments);
		
		service.addEmployee(employee);
		
		
	}
	
//	@Test
	public void findEmployee(){
		List<Employee> employees = service.findEmployees();
//		System.out.println(employees);
		assertEquals(employees.size(), 2);
	}
	
//	@Test
	public void findEmployeeById(){
		Employee employee = null;
		try {
			employee = service.findEmployee(-2);
			assertEquals(employee.getName(), "Arun");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		
	}
	
	@Test
	public void testAddIncrementToExistingEmployee(){
		Increment increment = new Increment(new Date(), 3000);
		Employee employee = service.applyIncrement(2, increment);
		
		assertEquals(employee.getIncrements().size(), 2);
	}

}
