package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/user")
	public String getUser(){
		System.out.println("In the controller");
		System.out.println("changed something");
		service.someServiceMethod();
		return "success";
	}

}
