package com.wissen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.wissen.config.AccountServiceConfiguration;
import com.wissen.service.TransferService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(AccountServiceConfiguration.class, args);
		
		TransferService transferService = context.getBean("transferService", TransferService.class);
		
		transferService.transfer(100, "1", "2");
	}

}
