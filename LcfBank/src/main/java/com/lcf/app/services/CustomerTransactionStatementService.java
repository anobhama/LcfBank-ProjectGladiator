package com.lcf.app.services;

import java.util.List;

import com.lcf.app.beans.CustomerTransactionStatement;

public interface CustomerTransactionStatementService {
	
	public abstract long setCustomerTransactionStatement(CustomerTransactionStatement customerTransactionStatement);
	public abstract List<CustomerTransactionStatement> getCustomerTransactionStatement(long customerId);

}
