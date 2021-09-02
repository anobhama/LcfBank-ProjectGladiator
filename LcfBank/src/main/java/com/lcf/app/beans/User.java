package com.lcf.app.beans;

public class User {
	
	private CustomerDetails customerDetailsObj;
	private AddressDetails permanentAddressObj;
	private AddressDetails residentialAddressObj;
	private LoginCredentials loginCredentialsObj;
	private AccountDetails accountDetailsObj;
	private long accountNumber;
	
	public User() {
		super();
	}
	
	public User(CustomerDetails customerDetailsObj, AddressDetails permanentAddressObj,
			AddressDetails residentialAddressObj) {
		super();
		this.customerDetailsObj = customerDetailsObj;
		this.permanentAddressObj = permanentAddressObj;
		this.residentialAddressObj = residentialAddressObj;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LoginCredentials getLoginCredentialsObj() {
		return loginCredentialsObj;
	}

	public void setLoginCredentialsObj(LoginCredentials loginCredentialsObj) {
		this.loginCredentialsObj = loginCredentialsObj;
	}

	public AccountDetails getAccountDetailsObj() {
		return accountDetailsObj;
	}

	public void setAccountDetailsObj(AccountDetails accountDetailsObj) {
		this.accountDetailsObj = accountDetailsObj;
	}

	public CustomerDetails getCustomerDetailsObj() {
		return customerDetailsObj;
	}
	public void setCustomerDetailsObj(CustomerDetails customerDetailsObj) {
		this.customerDetailsObj = customerDetailsObj;
	}
	public AddressDetails getPermanentAddressObj() {
		return permanentAddressObj;
	}
	public void setPermanentAddressObj(AddressDetails permanentAddressObj) {
		this.permanentAddressObj = permanentAddressObj;
	}
	public AddressDetails getResidentialAddressObj() {
		return residentialAddressObj;
	}
	public void setResidentialAddressObj(AddressDetails residentialAddressObj) {
		this.residentialAddressObj = residentialAddressObj;
	}
	
	@Override
	public String toString() {
		return "User [customerDetailsObj=" + customerDetailsObj + ", permanentAddressObj=" + permanentAddressObj
				+ ", residentialAddressObj=" + residentialAddressObj + "]";
	}
	
}