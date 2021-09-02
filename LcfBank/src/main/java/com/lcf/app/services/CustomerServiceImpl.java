package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	//calling DAO layer
	@Override
	public long newCustomer(CustomerDetails customer) {
		long id=customerDao.newCustomer(customer);
		return id;
	}
	
	@Override
	public CustomerDetails getCustomerById(long id) {
		CustomerDetails customer = customerDao.getCustomerById(id);
		return customer;
	}

}
