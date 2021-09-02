package com.lcf.app.services;

import com.lcf.app.beans.AccountDetails;

public interface AccountService {

	public abstract AccountDetails searchAccountByAccountNumber(long accountNumber);
	public abstract long insertAccount(AccountDetails accountDetails);
	public abstract AccountDetails searchAccountByCustomerId(long customerId);
}
