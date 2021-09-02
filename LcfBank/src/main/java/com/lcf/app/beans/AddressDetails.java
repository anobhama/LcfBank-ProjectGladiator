package com.lcf.app.beans;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "ADDRESS_DETAILS")
public class AddressDetails {
	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ADD_SEQ")
	@SequenceGenerator(name = "HB_ADD_SEQ", sequenceName = "AddressId_Sequence", allocationSize = 1)
	private long addressId;

	@Column(name = "ADDRESS_LINE_1")
	@NotNull
	private String addressLine1;

	@Column(name = "ADDRESS_LINE_2")
	private String addressLine2;

	@Column(name = "LANDMARK")
	private String landmark;

	@Column(name = "CITY")
	@NotNull
	private String city;

	@Column(name = "STATE")
	@NotNull
	private String state;

	@Column(name = "COUNTRY")
	@NotNull
	private String country = "India";

	@Column(name = "PINCODE")
	@NotNull
	private long pinCode;

	public AddressDetails() {
		super();
	}

	public AddressDetails(long addressId, String addressLine1, String addressLine2, String landmark, String city,
			String state, long pinCode) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
	}

	public AddressDetails(long addressId, String addressLine1, String addressLine2, String landmark, String city,
			String state, String country, long pinCode) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pinCode = pinCode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "AddressDetails \n [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", landmark=" + landmark + ", city=" + city + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}

}