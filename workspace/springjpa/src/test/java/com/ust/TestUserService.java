package com.ust;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ust.entity.Bookmark;
import com.ust.entity.User;

import static junit.framework.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestUserService {
	
	@Autowired
	UserService service;

//	@Test
	public void testAddUser() {
		Bookmark bookmark = new Bookmark("google.com");
		User user = new User("Ravi");
		List<Bookmark> bookmarks = new ArrayList<>();
		bookmarks.add(bookmark);
		
		user.setBookmarks(bookmarks);
		service.addUser(user);
		
	}
	
	@Test
	public void testFindUser(){
		User user = service.findUser(2);
		assertEquals("Ravi", user.getName());

	}

}
