package com.lcf.app.dao;

import java.util.List;

import com.lcf.app.beans.VerificationStatus;

public interface VerificationStatusDao {
	
	public abstract long createReference(VerificationStatus reference);
	public abstract VerificationStatus getReferenceById(long id);
	public abstract List<VerificationStatus> displayAll();

	public abstract boolean getStatusByReferenceId(long referenceId);

}
