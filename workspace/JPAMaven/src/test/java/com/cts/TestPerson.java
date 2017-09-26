package com.cts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cts.entity.Address;
import com.cts.entity.Bookmark;
import com.cts.entity.Person;
import com.cts.repo.PersonRepo;

public class TestPerson {
	
	private PersonRepo repo;

	@Before
	public void setup(){
		repo = new PersonRepo();
		
	}

	@Test
	public void test() {
		
		Person p = new Person("Arun");
		
		Address primaryAddress = new Address("Jangpura", "Delhi");
		Address secondryAddress = new Address("Hinjawadi", "Pune");
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(primaryAddress);
		addresses.add(secondryAddress);
		
		Bookmark bookmark1 = new Bookmark("google", "google.com");
		bookmark1.setPerson(p);
		Bookmark bookmark2 = new Bookmark("facebook", "facebook.com");
		bookmark2.setPerson(p);
		List<Bookmark> bookmarks = new ArrayList<>();
		bookmarks.add(bookmark1);
		bookmarks.add(bookmark2);
		
		p.setBookmarks(bookmarks);
		p.setAddresses(addresses);
		
		repo.addPerson(p);
		
	}
	
//	@Test
	public void testFindPerson() {
		
		Person p = repo.findPerson(1);
		assertEquals("Ravi", p.getName());
		System.out.println(p);
	}

}
