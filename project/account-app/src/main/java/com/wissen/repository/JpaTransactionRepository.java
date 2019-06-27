package com.wissen.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.wissen.model.Transaction;

@Repository("jpaTransactionRepository")
@Qualifier("jpa")
public class JpaTransactionRepository implements TransactionRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public JpaTransactionRepository() {
		
	}
	
	public void addTransaction(Transaction transaction) {
		em.persist(transaction);
	}
	
	

}
