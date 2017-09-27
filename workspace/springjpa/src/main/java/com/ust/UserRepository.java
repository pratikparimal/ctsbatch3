package com.ust;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ust.entity.User;

@Repository
public class UserRepository {
	@PersistenceContext
    private EntityManager em;
	
	public static void main(String[] args) {
//		Bookmark bookmark = new Bookmark("google.com");
//		User user = new User("Ravi");
//		List<Bookmark> bookmarks = new ArrayList<>();
//		bookmarks.add(bookmark);
//		
//		user.setBookmarks(bookmarks);
		
		UserRepository repository = new UserRepository();
//		repository.addUser(user);
		
		User user = repository.findUser(1);
		System.out.println(user);
	}
	
//	Step1. Create EMF
//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa"); 

	
	@Transactional
	public void addUser(User user){
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
			em.persist(user);
//		transaction.commit();
//		em.close();
	}
	
	@Transactional
	public User findUser(int id){
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
		User user = em.find(User.class, id);
		System.out.println(user);
//		transaction.commit();
//		em.close();
		return user;
	}
}
