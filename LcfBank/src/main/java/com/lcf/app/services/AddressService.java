package com.lcf.app.services;

import com.lcf.app.beans.AddressDetails;

public interface AddressService {

	public abstract long insertAddress(AddressDetails address);
	public abstract AddressDetails getAddressById(int addressId);
	public abstract AddressDetails getAddressById(long addressId);

}
