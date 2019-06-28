package com.wissen;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wissen.config.AccountServiceConfiguration;
import com.wissen.service.TxnService;

public class Application {
	
	public static void main(String[] args) {
		
		
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AccountServiceConfiguration.class);
		
		Log.ACCOUNT_APP.info("started...");
		
		TxnService transferer = context.getBean("txnService", TxnService.class);
		
		Log.ACCOUNT_APP.info("using service...");
		transferer.transfer("2", "1", 1730);
		
		
		
		Log.ACCOUNT_APP.info("ended...");
		
		context.close();
		
	}
}
