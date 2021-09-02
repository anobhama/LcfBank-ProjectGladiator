package com.lcf.app.beans;

public class Summary {

	private String date;
	private long transactionId;
	private String transactionInformation;
	private long amount;
	private long action;
	private long closingBalance;

	public Summary(String date, long transactionId, String transactionInformation, long amount, long action,
			long closingBalance) {
		super();
		this.date = date;
		this.transactionId = transactionId;
		this.transactionInformation = transactionInformation;
		this.amount = amount;
		this.action = action;
		this.closingBalance = closingBalance;
	}

	public Summary() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionInformation() {
		return transactionInformation;
	}

	public void setTransactionInformation(String transactionInformation) {
		this.transactionInformation = transactionInformation;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public long getAction() {
		return action;
	}

	public void setAction(long action) {
		this.action = action;
	}

	public long getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(long closingBalance) {
		this.closingBalance = closingBalance;
	}

	@Override
	public String toString() {
		return "Summary [date=" + date + ", transactionId=" + transactionId + ", transactionInformation="
				+ transactionInformation + ", amount=" + amount + ", action=" + action + ", closingBalance="
				+ closingBalance + "]";
	}

}
