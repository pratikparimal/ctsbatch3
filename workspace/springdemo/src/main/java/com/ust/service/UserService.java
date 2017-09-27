package com.ust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	
	@Autowired
	UserRepository repository;
	
//	public UserService(UserRepository repository){
//		this.repository = repository;
////		repository = new UserRepository();
//	}
//	
//	var controller = app.controller(function ($scope, $http))
	
	public void addUser(){
		//Need repository to make changes to db
		
		System.out.println("In the service class -- going to invoke the repository for db operation");
		repository.addUser();
	}

}
