package com.lcf.app.dao;

import com.lcf.app.beans.AccountDetails;

public interface AccountDao {

	AccountDetails searchAccountByAccountNumber(long accountNumber);

	long insertAccount(AccountDetails accountDetails);

	AccountDetails searchAccountByCustomerId(long customerId);

}
