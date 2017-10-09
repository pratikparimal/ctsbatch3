package com.cts.controller;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.entity.Employee;
import com.cts.entity.Increment;
import com.cts.service.EmployeeService;

@Controller
public class EmployeeController {
	
	Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping("/employees")
	public void fetchEmployees(Model model){
		System.out.println("url hit");
		
		List<Employee> employees = service.findEmployees();
		System.out.println(employees);
		model.addAttribute("emps", employees);
	}
	
	
	@RequestMapping(value="/increment", method=RequestMethod.GET)
	public String getIncrement(Model model, @RequestParam("empid") int empid){
		Increment increment = new Increment();
		Employee emp = new Employee();
		emp.setId(empid);
		increment.setEmployee(emp);
		
		model.addAttribute("increment", increment);
		return "increment";
	}
	
	@RequestMapping(value = "/increment", method = RequestMethod.POST)
	public String applyIncrement(
		@ModelAttribute("increment")Increment increment,
		BindingResult result, 
		Model model) {
		
		int id = increment.getEmployee().getId();
//		increment.setEmployee(null);
		
		logger.warn(increment);
		logger.warn(increment.getEmployee());
		increment.setIncrementDate(new Date());
		Employee employee = service.applyIncrement(id, increment);
		model.addAttribute("emp", employee);
		
		return "employee";
	}
	
	@RequestMapping("/employee")
	public String fetchEmployee(Model model,@RequestParam("id") int id){

		Employee employee =null;
		try {
			employee = service.findEmployee(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(employee);
		if(employee!=null){
			model.addAttribute("emp", employee);
			return "employee";
		}
		return "error";
				
		
		
	}

}
