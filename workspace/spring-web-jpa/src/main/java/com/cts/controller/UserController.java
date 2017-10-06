package com.cts.controller;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@XmlRootElement
class User implements Serializable{
	private static final long serialVersionUID = 1L;
	String name;
	public User (String name){
		this.name = name;
	}
	public User(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

@RestController
@RequestMapping(value="/api")
public class UserController {

	@RequestMapping(value="/user", method=RequestMethod.GET )
	public User getUser(){
		User user = new User("Ravi");
		System.out.println(user);
		return user;
	}
	
	

}
