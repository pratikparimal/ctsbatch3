package com.cts.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
	
	
}

@RestController
@RequestMapping(value="/api")
public class UserController {
	
	Map<String,User> usersMap = new HashMap<>();
	
	@RequestMapping(value="/users", method=RequestMethod.GET )
	public List<User> getUsers(){
		List<User> users = new ArrayList<>();
		for(String name: usersMap.keySet()){
			users.add(usersMap.get(name));
		}
		System.out.println(users);
		return users;
	}

	@RequestMapping(value="/user/:name", method=RequestMethod.GET )
	public User getUser(@PathVariable ("name") String name){
//		User user = new User("Ravi");
		User user = usersMap.get(name);
		System.out.println(user);
		return user;
	}
	
	
	@RequestMapping(value="/user", method=RequestMethod.POST )
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@RequestBody User user){
		System.out.println(user);
		usersMap.put(user.getName(), user);
		//Insert the user to the DB
	}
	
	

}
