package com.lcf.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.CustomerTransactionStatement;
import com.lcf.app.dao.CustomerTransactionStatementDao;

@Service
public class CustomerTransactionStatementServiceImpl implements CustomerTransactionStatementService{
	
	@Autowired
	CustomerTransactionStatementDao customerTransactionStatementDao;

	@Override
	public long setCustomerTransactionStatement(CustomerTransactionStatement customerTransactionStatement) {
		long sNo = customerTransactionStatementDao.setCustomerTransactionStatement(customerTransactionStatement);
		return sNo;
	}

	@Override
	public List<CustomerTransactionStatement> getCustomerTransactionStatement(long customerId) {
		List<CustomerTransactionStatement> customerTransactionStatement = customerTransactionStatementDao.getCustomerTransactionStatement(customerId);
		return customerTransactionStatement;
	}

}
