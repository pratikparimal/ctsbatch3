package com.ust;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ust.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestUserService {

	@Autowired
	UserService service;
	
	@Test
	public void testAddUser() {
//		UserRepository repository = new UserRepository();
//		UserService service = new UserService(repository);
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		UserService service = context.getBean("userService",UserService.class);
		
		service.addUser();
	}

}
