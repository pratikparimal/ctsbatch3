package com.ust.service;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	public void addUser(){
		System.out.println("In user repository -- trying to add user to db");
	}
}
