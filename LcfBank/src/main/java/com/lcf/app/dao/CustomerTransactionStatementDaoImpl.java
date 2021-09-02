package com.lcf.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.CustomerTransactionStatement;

@Repository("customerTransactionStatementDao")
@EnableTransactionManagement
public class CustomerTransactionStatementDaoImpl implements CustomerTransactionStatementDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public long setCustomerTransactionStatement(CustomerTransactionStatement customerTransactionStatement) {
		em.persist(customerTransactionStatement);
		return customerTransactionStatement.getsNo();
	}

	@Override
	public List<CustomerTransactionStatement> getCustomerTransactionStatement(long customerId) {
		List<CustomerTransactionStatement> customerTransactionStatement = em.createQuery("select stmt from CustomerTransactionStatement stmt"
																					+ " where stmt.customerId =:customerId").setParameter("customerId", customerId).getResultList();
		return customerTransactionStatement;
	}
	
	

}