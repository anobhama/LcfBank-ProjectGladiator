package com.lcf.app.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.lcf.app.beans.CustomerDetails;
import com.lcf.app.beans.VerificationStatus;

public interface CustomerDao {
	
	public abstract long newCustomer(CustomerDetails customer);
	public abstract CustomerDetails getCustomerById(long id);
	
}
