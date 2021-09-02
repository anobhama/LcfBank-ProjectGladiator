package com.lcf.app.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "CUSTOMER_TRANSACTION_STATEMENT")
public class CustomerTransactionStatement {

	@Id
	@Column(name = "S_NO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ACC_SEQ")
	@SequenceGenerator(name = "HB_ACC_SEQ", sequenceName = "S_No_Sequence", allocationSize = 1)
	private long sNo;

	@Column(name = "TRANSACTION_ID")
	@NotNull
	private long transactionId;
	
	@Column(name = "CUSTOMER_ID")
	@NotNull
	private long customerId;
	
	@Column(name = "CLOSING_BALANCE")
	@NotNull
	private long closingBalance;
	
	@Column(name = "ACTION")
	@NotNull
	private long action;

	public long getsNo() {
		return sNo;
	}

	public void setsNo(long sNo) {
		this.sNo = sNo;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(long closingBalance) {
		this.closingBalance = closingBalance;
	}

	public long getAction() {
		return action;
	}

	public void setAction(long action) {
		this.action = action;
	}

	public CustomerTransactionStatement(long sNo, long transactionId, long customerId, long closingBalance,
			long action) {
		super();
		this.sNo = sNo;
		this.transactionId = transactionId;
		this.customerId = customerId;
		this.closingBalance = closingBalance;
		this.action = action;
	}

	public CustomerTransactionStatement() {
		super();
	}

	@Override
	public String toString() {
		return "CustomerTransactionStatement [sNo=" + sNo + ", transactionId=" + transactionId + ", customerId="
				+ customerId + ", closingBalance=" + closingBalance + ", action=" + action + "]";
	}

}
