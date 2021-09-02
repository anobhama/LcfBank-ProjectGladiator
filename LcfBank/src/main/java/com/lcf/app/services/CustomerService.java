package com.lcf.app.services;

import com.lcf.app.beans.CustomerDetails;

public interface CustomerService {
	
	public abstract long newCustomer(CustomerDetails customer);
	public abstract CustomerDetails getCustomerById(long id);

}
