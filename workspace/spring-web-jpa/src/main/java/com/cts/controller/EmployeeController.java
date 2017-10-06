package com.cts.controller;

import java.util.Date;
import java.util.List;

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
	public String getIncrement(Model model){
		model.addAttribute("increment", new Increment());
		return "increment";
	}
	
	@RequestMapping(value = "/increment", method = RequestMethod.POST)
	public String applyIncrement(
		@ModelAttribute("increment")Increment increment,
		BindingResult result, 
		Model model) {
		
		System.out.println(increment);
		increment.setIncrementDate(new Date());
		Employee employee = service.applyIncrement(2, increment);
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
