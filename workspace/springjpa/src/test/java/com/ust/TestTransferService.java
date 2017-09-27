package com.ust;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestTransferService {
	
	@Autowired
	TransferService service;

	@Test
	public void test() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//		TransferService service = context.getBean(TransferService.class);
		service.transfer();
	}

}
