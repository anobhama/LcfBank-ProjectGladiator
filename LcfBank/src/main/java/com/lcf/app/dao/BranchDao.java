package com.lcf.app.dao;

import org.springframework.web.bind.annotation.RequestBody;

import com.lcf.app.beans.BranchDetails;

public interface BranchDao {
	
	public abstract BranchDetails getBranchByIfsc(String ifsc);
	public abstract String insertBranch(BranchDetails branchDetails);

}
