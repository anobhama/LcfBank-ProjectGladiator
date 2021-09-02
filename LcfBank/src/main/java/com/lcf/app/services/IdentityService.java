package com.lcf.app.services;

import com.lcf.app.beans.IdentityDocuments;

public interface IdentityService {
	
	public abstract long insertIdentityDocuments(IdentityDocuments identityDocuments);
	public abstract IdentityDocuments getIdentityDocumentsById(long customerId);

}
