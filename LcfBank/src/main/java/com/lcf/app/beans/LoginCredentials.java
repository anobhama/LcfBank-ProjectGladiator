package com.lcf.app.beans;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "LOGIN_CREDENTIALS")
public class LoginCredentials {

	@Id
	@Column(name = "CUSTOMER_ID")
	private long customerId;

	@Column(name = "LOGIN_PASSWORD")
	@NotNull
	private String loginPassword;

	@Column(name = "TRANSACTION_PIN")
	@NotNull
	private int transactionPin;

	public LoginCredentials() {
		super();
	}

	public LoginCredentials(long customerId, String loginPassword, int transactionPin) {
		super();
		this.customerId = customerId;
		this.loginPassword = loginPassword;
		this.transactionPin = transactionPin;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public int getTransactionPin() {
		return transactionPin;
	}

	public void setTransactionPin(int transactionPin) {
		this.transactionPin = transactionPin;
	}

	@Override
	public String toString() {
		return "LoginCredentials \n [customerId=" + customerId + ", loginPassword=" + loginPassword
				+ ", transactionPin=" + transactionPin + "]";
	}

}