package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.AccountDetails;
import com.lcf.app.dao.AccountDao;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDao accountDao;
	
	@Override
	public AccountDetails searchAccountByAccountNumber(long accountNumber) {
		AccountDetails account = accountDao.searchAccountByAccountNumber(accountNumber);
		return account;
	}

	@Override
	public long insertAccount(AccountDetails accountDetails) {
		long accountNumber = accountDao.insertAccount(accountDetails);
		return accountNumber;
	}

	@Override
	public AccountDetails searchAccountByCustomerId(long customerId) {
		AccountDetails account = accountDao.searchAccountByCustomerId(customerId);
		return account;
	}
}
