package com.ust;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
	
	@Autowired
	TransferRepository repo;
	
	TransferService(){
	}
	
	public void transfer(){
		System.out.println("In Service Class");
		repo.fetchAccount();
	}

}
