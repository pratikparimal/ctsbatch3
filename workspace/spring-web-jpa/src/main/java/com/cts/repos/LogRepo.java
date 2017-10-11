package com.cts.repos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.IncrementRequest;

@Repository
public class LogRepo {

	Logger logger = Logger.getLogger(getClass());
	@PersistenceContext
	EntityManager em;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void logIncrementRequest(IncrementRequest increq){
		em.persist(increq);
	}
}
