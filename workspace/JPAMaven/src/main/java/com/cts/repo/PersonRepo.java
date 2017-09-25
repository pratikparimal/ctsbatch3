package com.cts.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.entity.Person;

public class PersonRepo {
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa"); 

	public void addPerson(Person p){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
		em.close();
		
	}

	public Person findPerson(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Person p = em.find(Person.class, id);
		System.out.println(p);
		transaction.commit();
		em.close();
		return p;
		
	}

}
