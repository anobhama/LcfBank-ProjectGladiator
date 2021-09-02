package com.lcf.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lcf.app.beans.TransactionDetails;

@Repository("transactionDao")
public class TransactionDaoImpl implements TransactionDao {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public long commitTransaction(TransactionDetails transaction) {
		System.out.println(transaction);
		em.persist(transaction);
		return transaction.getTransactionId();
	}

	@Override
	public TransactionDetails transactionDetails(long transactionId) {
		TransactionDetails transactionDetails = em.find(TransactionDetails.class, transactionId);

		return transactionDetails;
	}

}
