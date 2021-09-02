package com.lcf.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcf.app.beans.AddressDetails;
import com.lcf.app.dao.AddressDao;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDao addressDao;
	
	@Override
	public long insertAddress(AddressDetails address) {
		
		long id= addressDao.insertAddress(address);
		return id;
	}

	@Override
	public AddressDetails getAddressById(long addressId) {
		AddressDetails address = addressDao.getAddressById(addressId);
		return address;
	}

	@Override
	public AddressDetails getAddressById(int addressId) {
		// TODO Auto-generated method stub
		return null;
	}

}
