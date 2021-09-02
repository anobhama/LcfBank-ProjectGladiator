package com.lcf.app.dao;

import com.lcf.app.beans.AddressDetails;

public interface AddressDao {
	
	public abstract long insertAddress(AddressDetails address);
	public abstract AddressDetails getAddressById(long addressId);

}
