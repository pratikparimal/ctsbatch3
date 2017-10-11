package com.cts.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

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
		@ModelAttribute("increment") @Valid Increment increment,
		BindingResult result, 
		Model model) {
		
//		if(increment.getAmount()<1){
//			result.reject("amount", null, "Amount should be greater than 1");
//		}
		
		int id = increment.getEmployee().getId();
//		increment.setEmployee(null);
		
		logger.warn(increment);
		logger.warn(increment.getEmployee());
		increment.setIncrementDate(new Date());
		Employee employee = null;
		try{
			employee = service.applyIncrement(id, increment);
		}
		catch(Exception e){
			logger.error("---------");
			logger.error(e.getCause().getCause().getMessage());
			logger.error(e.getMessage());
			e.printStackTrace();
			ConstraintViolationException exception = (ConstraintViolationException) e.getCause().getCause();
			Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while(iterator.hasNext()){
				ConstraintViolation<?> next = iterator.next();
				System.out.println("Validation message: "+next.getMessage());
				System.out.println("Invalid field: "+next.getPropertyPath());
				System.out.println("Validation class/bean: "+next.getRootBean());
				result.reject(next.getPropertyPath().toString(), null, next.getMessage());
			}
			return "increment";	
		}
		
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
