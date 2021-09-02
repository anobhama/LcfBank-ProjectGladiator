package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.IdentityDocuments;

@Repository("identityDao")
@EnableTransactionManagement
public class IdentityDaoImpl implements IdentityDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public long insertIdentityDocuments(IdentityDocuments identityDocuments) {
		System.out.println("dao");
		em.persist(identityDocuments);
		return identityDocuments.getCustomerId();
	}

	@Override
	public IdentityDocuments getIdentityDocumentsById(long customerId) {
		IdentityDocuments identity = em.find(IdentityDocuments.class, customerId);
		return identity;
	}

}
