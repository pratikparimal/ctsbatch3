package com.cts.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping(value="/increment",method=RequestMethod.GET)
	public Increment fetchIncrement(){
		
	Increment increment = new Increment(new Date(), 3423);
	return increment;
	}
}
