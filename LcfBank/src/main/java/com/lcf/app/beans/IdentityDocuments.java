package com.lcf.app.beans;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "IDENTITY_DOCUMENT")
public class IdentityDocuments {

	@Id
	@Column(name = "CUSTOMER_ID")
	private long customerId;

	@Column(name = "AADHAAR_NUMBER")
	@NotNull
	private long aadharNumber;

	@Column(name = "PAN")
	@NotNull
	private String pan;

	public IdentityDocuments() {
		super();
	}

	public IdentityDocuments(long customerId, long aadharNumber, String pan) {
		super();
		this.customerId = customerId;
		this.aadharNumber = aadharNumber;
		this.pan = pan;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "IdentityDocuments \n [customerId=" + customerId + ", aadharNumber=" + aadharNumber + ", pan=" + pan
				+ "]";
	}

}
