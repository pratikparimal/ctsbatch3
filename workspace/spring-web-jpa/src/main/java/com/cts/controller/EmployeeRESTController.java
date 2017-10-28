package com.cts.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Employee;
import com.cts.entity.Increment;
import com.cts.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping(value="/employees",method=RequestMethod.GET)
	public List<Employee> fetchEmployees(){
		System.out.println("rest url hit");
		
		List<Employee> employees = service.findEmployees();
		System.out.println(employees);
		
		return employees;
	}
	@RequestMapping(value="/employee/{empid}",method=RequestMethod.GET)
	public Employee fetchEmployee(@PathVariable("empid") int empid){
		System.out.println("rest url hit");
		
		Employee employee = null;
		try {
			employee = service.findEmployee(empid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
					
		}
		System.out.println(employee);
		
		return employee;
	}
	
	@RequestMapping(value="/increment",method=RequestMethod.GET)
	public Increment fetchIncrement(){
		
	Increment increment = new Increment(new Date(), 3423);
	return increment;
	}
}
