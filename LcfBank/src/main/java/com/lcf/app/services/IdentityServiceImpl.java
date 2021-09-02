package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.IdentityDocuments;
import com.lcf.app.dao.IdentityDao;

@Service
public class IdentityServiceImpl implements IdentityService{
	
	@Autowired
	IdentityDao identityDao;

	@Override
	public long insertIdentityDocuments(IdentityDocuments identityDocuments) {
		long customerId = identityDao.insertIdentityDocuments(identityDocuments);
		return customerId;
	}

	@Override
	public IdentityDocuments getIdentityDocumentsById(long customerId) {
		IdentityDocuments identity = identityDao.getIdentityDocumentsById(customerId);
		return identity;
	}

}
