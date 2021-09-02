package com.lcf.app.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.lcf.app.beans.BranchDetails;

public interface BranchService {
	
	public abstract BranchDetails getBranchByIfsc(String ifsc);
	public abstract String insertBranch(BranchDetails branchDetails);
}
