package com.cts.repos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.User;

@Repository
public class UserRepository {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void addUser(User user){
		em.persist(user);
		System.out.println("Add a user to DB!!" + user);
	}

	public User findUser(int id) {
		User user = em.find(User.class, id);
		return user;
	}
}
