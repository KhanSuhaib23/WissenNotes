package com.wissen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wissen.repository.AccountRepository;
import com.wissen.repository.TransactionRepository;
import com.wissen.service.NeftTxnService;
import com.wissen.service.TxnService;

@EnableTransactionManagement
@Configuration
@Import (value = {DataSourceConfiguration.class, TransactionManagerConfiguration.class, MvcConfiguration.class})
@ComponentScan (value = {"com.wissen.repository", "com.wissen.service", "com.wissen.aspect", "com.wissen.web"})
public class AccountServiceConfiguration {
	
	@Autowired
	@Qualifier("jpa")
	private AccountRepository accRepo;
	
	@Autowired
	@Qualifier("jpa")
	private TransactionRepository txnRepo;
	
	@Bean
	public TxnService txnService() {
		TxnService txnService = new NeftTxnService(accRepo, txnRepo);
		
		return txnService;
	}
	
}
