package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.CustomerDetails;

@Repository("customerDao")
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	@PersistenceContext
	EntityManager em;
	
	//adding new customer details via customerdetails class
	@Override
	@Transactional
	public long newCustomer(CustomerDetails customer) {
		System.out.println("dao");
		em.persist(customer);
		return customer.getCustomerId();
	}
	
	//searching customer by id
	@Override
	@Transactional
	public CustomerDetails getCustomerById(long id) {
		CustomerDetails customer = em.find(CustomerDetails.class, id);
		return customer;
	}
	

}
