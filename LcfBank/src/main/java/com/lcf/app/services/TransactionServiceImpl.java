package com.lcf.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.AccountDetails;
import com.lcf.app.beans.TransactionDetails;
import com.lcf.app.dao.TransactionDao;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDao transactionDao;

	@Override
	public long commitTransaction(TransactionDetails transaction) {
		long transactionId = transactionDao.commitTransaction(transaction);
		return transactionId;
	}

	@Override
	public TransactionDetails transactionDetails(long transactionId) {
		TransactionDetails transactionDetails = transactionDao.transactionDetails(transactionId);
		return transactionDetails;
	}

}
