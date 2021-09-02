package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.BranchDetails;
import com.lcf.app.dao.BranchDao;

@Service
public class BranchServiceImpl implements BranchService{

	@Autowired
	BranchDao branchDao;
	
	@Override
	public BranchDetails getBranchByIfsc(String ifsc) {
		BranchDetails branch = branchDao.getBranchByIfsc(ifsc);
		return branch;
	}

	@Override
	public String insertBranch(BranchDetails branchDetails) {
		String ifsc = branchDao.insertBranch(branchDetails);
		return ifsc;
	}

}
