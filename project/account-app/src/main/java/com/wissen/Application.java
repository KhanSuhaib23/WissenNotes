package com.wissen;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wissen.service.TxnService;

public class Application {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("account-service.xml");
		
		Log.ACCOUNT_APP.info("started...");
		
		TxnService transferer = context.getBean("txnService", TxnService.class);
		
		Log.ACCOUNT_APP.info("using service...");
		transferer.tranfer("2", "1", 500);
		
		Log.ACCOUNT_APP.info("ended...");
		
	}
}
