package com.lcf.app.services;

import java.util.List;

import com.lcf.app.beans.AccountDetails;
import com.lcf.app.beans.TransactionDetails;

public interface TransactionService {
	
	public abstract long commitTransaction(TransactionDetails transaction);
	public abstract TransactionDetails transactionDetails(long transactionId);
	

}
