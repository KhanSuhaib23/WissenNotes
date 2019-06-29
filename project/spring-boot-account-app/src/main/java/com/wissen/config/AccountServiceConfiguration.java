package com.wissen.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = { "com.wissen.model" })
@EnableJpaRepositories(basePackages = { "com.wissen.repository" })
@ComponentScan(basePackages = { "com.wissen.repository", "com.wissen.service" })
@EnableAutoConfiguration
public class AccountServiceConfiguration {

}
