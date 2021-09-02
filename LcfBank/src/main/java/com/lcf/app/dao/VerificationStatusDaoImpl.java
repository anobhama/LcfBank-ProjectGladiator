
package com.lcf.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lcf.app.beans.VerificationStatus;

@Repository("referenceDao")
public class VerificationStatusDaoImpl implements VerificationStatusDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public long createReference(VerificationStatus reference) {
		em.persist(reference);
		
		return reference.getReferenceId();
	}

	@Override
	public VerificationStatus getReferenceById(long id) {
		System.out.println("dao ref \n"+id);
		VerificationStatus reference = em.find(VerificationStatus.class, id);
		System.out.println("dao ref after \n"+reference);
		return reference;
	}

	@Override
	public List<VerificationStatus> displayAll() {
		List<VerificationStatus> referenceList = em.createQuery("SELECT obj FROM VerificationStatus obj").getResultList();
		
		return referenceList;
	}

	@Override
	@Transactional
	public boolean getStatusByReferenceId(long referenceId) {
		VerificationStatus reference = em.find(VerificationStatus.class, referenceId);
		reference.setVerified('Y');
		em.merge(reference);
		return true;
		
	}

}
