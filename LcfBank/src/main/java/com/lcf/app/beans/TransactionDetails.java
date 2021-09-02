package com.lcf.app.beans;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TRANSACTION_DETAILS")
public class TransactionDetails {

	@Id
	@Column(name = "TRANSACTION_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_ACC_SEQ")
	@SequenceGenerator(name = "HB_ACC_SEQ", sequenceName = "Transaction_Id_Sequence", allocationSize = 1)
	private long transactionId;

	@Column(name = "BENEFACTOR_ACC_NO")
	@NotNull
	private long benefactorAccNumber;
	
	@Column(name = "BENEFICIARY_ACC_NO")
	private long beneficiaryAccNumber;
	
	@Column(name = "BENEFICIARY_ACCOUNT_INFO")
	@NotNull
	private String beneficiaryAccountInfo;
	
	@Column(name = "AMOUNT")
	@NotNull
	private long amount;
	
	@Column(name = "DATE_OF_TRANSACTION")
	@NotNull
	private String dateOfTransaction;

	@Column(name = "MODE_OF_TRANSACTION")
	@NotNull
	private String modeOfTransaction;

	@Column(name = "STATUS")
	@NotNull
	private String status;

	@Column(name = "REMARKS")
	@NotNull
	private String remarks;

	public TransactionDetails() {
		super();
	}

	public TransactionDetails(long transactionId, long benefactorAccNumber, long beneficiaryAccNumber,
			String beneficiaryAccountInfo, long amount, String dateOfTransaction, String modeOfTransaction,
			String status, String remarks) {
		super();
		this.transactionId = transactionId;
		this.benefactorAccNumber = benefactorAccNumber;
		this.beneficiaryAccNumber = beneficiaryAccNumber;
		this.beneficiaryAccountInfo = beneficiaryAccountInfo;
		this.amount = amount;
		this.dateOfTransaction = dateOfTransaction;
		this.modeOfTransaction = modeOfTransaction;
		this.status = status;
		this.remarks = remarks;

	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getBenefactorAccNumber() {
		return benefactorAccNumber;
	}

	public void setBenefactorAccNumber(long benefactorAccNumber) {
		this.benefactorAccNumber = benefactorAccNumber;
	}

	public long getBeneficiaryAccNumber() {
		return beneficiaryAccNumber;
	}

	public void setBeneficiaryAccNumber(long beneficiaryAccNumber) {
		this.beneficiaryAccNumber = beneficiaryAccNumber;
	}

	public String getBeneficiaryAccountInfo() {
		return beneficiaryAccountInfo;
	}

	public void setBeneficiaryAccountInfo(String beneficiaryAccountInfo) {
		this.beneficiaryAccountInfo = beneficiaryAccountInfo;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(String dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public String getModeOfTransaction() {
		return modeOfTransaction;
	}

	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "FetchTransaction [transactionId=" + transactionId + ", benefactorAccNumber=" + benefactorAccNumber
				+ ", beneficiaryAccNumber=" + beneficiaryAccNumber + ", beneficiaryAccountInfo="
				+ beneficiaryAccountInfo + ", amount=" + amount + ", dateOfTransaction=" + dateOfTransaction
				+ ", modeOfTransaction=" + modeOfTransaction + ", status=" + status + ", remarks=" + remarks + "]";
	}

}