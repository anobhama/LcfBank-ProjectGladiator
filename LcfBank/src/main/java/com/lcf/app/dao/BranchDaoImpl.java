package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lcf.app.beans.BranchDetails;

@Repository("branchDao")
public class BranchDaoImpl implements BranchDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public BranchDetails getBranchByIfsc(String ifsc) {
		
		BranchDetails branch = em.find(BranchDetails.class, ifsc);
		return branch;
		
	}

	@Override
	@Transactional
	public String insertBranch(BranchDetails branchDetails) {
		em.persist(branchDetails);
		return branchDetails.getIfsc();
	}

}
