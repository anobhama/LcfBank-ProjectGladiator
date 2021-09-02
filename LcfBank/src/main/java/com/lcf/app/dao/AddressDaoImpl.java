package com.lcf.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.lcf.app.beans.AddressDetails;
import com.lcf.app.beans.CustomerDetails;

@Repository("addressDao")
@EnableTransactionManagement
public class AddressDaoImpl implements AddressDao{
	
	@PersistenceContext
	 private EntityManager em;

	@Override
	@Transactional
	public long insertAddress(AddressDetails address) {
		em.persist(address);
		return address.getAddressId();
	}

	@Override
	public AddressDetails getAddressById(long addressId) {
		AddressDetails address = em.find(AddressDetails.class, addressId);
		return address;
	}

}
