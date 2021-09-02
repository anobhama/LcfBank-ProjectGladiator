package com.lcf.app.dao;

import java.util.List;

import com.lcf.app.beans.CustomerTransactionStatement;

public interface CustomerTransactionStatementDao {
	
	public abstract long setCustomerTransactionStatement(CustomerTransactionStatement customerTransactionStatement);
	public abstract List<CustomerTransactionStatement> getCustomerTransactionStatement(long customerId);

}
