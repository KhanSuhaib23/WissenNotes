package com.wissen.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	public List<Transaction> getAllTransaction() {
		return em.createQuery("from Transaction t").getResultList();
	}

	@Override
	public List<Transaction> getTransactionByAccount(String accNum) {
		Query query = em.createQuery("from Transaction t where t.account.accountNum = ?1");
		query.setParameter(1, accNum);
		return query.getResultList();
	}

}
