package com.wissen.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.wissen.model.Account;


@Repository("jpaAccountRepository")
@Qualifier("jpa")
public class JpaAccountRepository implements AccountRepository {

	@PersistenceContext
	private EntityManager em;

	
	public Account get(String accNum) {
		return em.find(Account.class, accNum);
	}

	@Override
	public boolean update(Account account) {
		em.merge(account);
		return true;
	}

}
