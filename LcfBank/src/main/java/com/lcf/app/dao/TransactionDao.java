package com.lcf.app.dao;

import java.util.List;

import com.lcf.app.beans.AccountDetails;
import com.lcf.app.beans.TransactionDetails;

public interface TransactionDao {
	
	public abstract long commitTransaction(TransactionDetails transaction);
	public abstract TransactionDetails transactionDetails(long transactionId);

}
