package com.lcf.app.dao;

import com.lcf.app.beans.IdentityDocuments;

public interface IdentityDao {
	
	public abstract long insertIdentityDocuments(IdentityDocuments identityDocuments);
	public abstract IdentityDocuments getIdentityDocumentsById(long customerId);

}
