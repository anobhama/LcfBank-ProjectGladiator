package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lcf.app.beans.AccountDetails;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public AccountDetails searchAccountByAccountNumber(long accountNumber) {
		AccountDetails account = em.find(AccountDetails.class, accountNumber);
		return account;
	}

	@Override
	@Transactional
	public long insertAccount(AccountDetails accountDetails) {
		em.merge(accountDetails);
		return accountDetails.getAccountNumber();
	}

	@Override
	public AccountDetails searchAccountByCustomerId(long customerId) {
		
		System.out.println("b4" + customerId);
		TypedQuery<AccountDetails> tq = em.createQuery("from AccountDetails where customerId=?1", AccountDetails.class);
		AccountDetails account = tq.setParameter(1,customerId).getSingleResult();
		
		System.out.println("after" + customerId+account);
		return account;
		
	}

}