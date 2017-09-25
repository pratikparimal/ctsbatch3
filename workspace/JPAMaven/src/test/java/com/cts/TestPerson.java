package com.cts;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cts.entity.Address;
import com.cts.entity.Person;
import com.cts.repo.PersonRepo;

public class TestPerson {
	
	private PersonRepo repo;

	@Before
	public void setup(){
		repo = new PersonRepo();
		
	}

//	@Test
	public void test() {
		
		Person p = new Person("Ravi");
		
		Address primaryAddress = new Address("GK", "Delhi");
		Address secondryAddress = new Address("Aundh", "Pune");
		
		List<Address> addresses = new ArrayList<>();
		addresses.add(primaryAddress);
		addresses.add(secondryAddress);
		
		p.setAddresses(addresses);
		
		repo.addPerson(p);
		
	}
	
	@Test
	public void testFindPerson() {
		
		Person p = repo.findPerson(1);
		assertEquals("Ravi", p.getName());
		System.out.println(p);
	}

}
