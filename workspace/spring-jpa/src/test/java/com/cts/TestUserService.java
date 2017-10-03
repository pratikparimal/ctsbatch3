package com.cts;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cts.entity.User;
import com.cts.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestUserService {
	
	@Autowired
	UserService service;

//	@Test
	public void test() {
		User user = new User("Ravi");
		service.addUser(user);
	}
	
	@Test
	public void testFindUser() {
		User user = service.findUser(1);
		System.out.println(user);
		assertEquals(user.getName(), "Ravi");
	}

}
