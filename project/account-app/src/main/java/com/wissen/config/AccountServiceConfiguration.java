package com.wissen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@Import (value = {DataSourceConfiguration.class, TransactionManagerConfiguration.class})
@ComponentScan (value = {"com.wissen.repository", "com.wissen.service", "com.wissen.aspect"})
public class AccountServiceConfiguration {
	
}
