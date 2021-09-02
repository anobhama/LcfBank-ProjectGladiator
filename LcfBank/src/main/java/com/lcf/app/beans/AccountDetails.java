package com.lcf.app.beans;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "ACCOUNT_DETAILS")
public class AccountDetails {

	@Id
	@Column(name = "ACCOUNT_NUMBER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ACC_SEQ")
	@SequenceGenerator(name = "HB_ACC_SEQ", sequenceName = "Account_Number_Sequence", allocationSize = 1)
	private long accountNumber;

	@Column(name = "ACCOUNT_TYPE")
	@NotNull
	private String accountType = "Savings";

	@Column(name = "AVAILABLE_BALANCE")
	@NotNull
	private long availableBalance = 5000;

	@Column(name = "IFSC")
	@NotNull
	private String ifsc = "LCNF7382";

	@Column(name = "CUSTOMER_ID")
	@NotNull
	private long customerId;

	public AccountDetails() {
		super();
	}

	public AccountDetails(long accountNumber, String accountType, long availableBalance, String ifsc, long customerId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.ifsc = ifsc;
		this.customerId = customerId;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public long getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(long availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", accountType=" + accountType + ", availableBalance="
				+ availableBalance + ", ifsc=" + ifsc + ", customerId=" + customerId + "]";
	}

}