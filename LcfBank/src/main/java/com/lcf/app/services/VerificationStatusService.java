package com.lcf.app.services;

import java.util.List;

import com.lcf.app.beans.VerificationStatus;

public interface VerificationStatusService {
	
	public abstract long createReference(VerificationStatus reference);
	public abstract VerificationStatus getReferenceById(long id);
	public abstract List<VerificationStatus> displayAll();
	public abstract boolean getStatusByReferenceId(long referenceId);
}
