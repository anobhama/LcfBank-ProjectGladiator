package com.lcf.app.beans;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {

	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_CUST_SEQ")
	@SequenceGenerator(name = "HB_CUST_SEQ", sequenceName = "CustomerId_Sequence", allocationSize = 1)
	private long customerId;

	@Column(name = "CUSTOMER_NAME")
	@NotNull
	private String customerName;

	@Column(name = "CONTACT_NUMBER")
	@NotNull
	private long contactNumber;

	@Column(name = "DOB")
	@NotNull
	private String dob;

	@Column(name = "GENDER")
	@NotNull
	private String gender;

	@Column(name = "OCCUPATION")
	@NotNull
	private String occupation;

	@Column(name = "ANNUAL_INCOME")
	private long annualIncome;

	@Column(name = "EMAIL_ID")
	@NotNull
	private String emailId;

	@Column(name = "RESIDENTIAL_ADDRESS_ID")
	@NotNull
	private long residentialAddressId;

	@Column(name = "PERMANENT_ADDRESS_ID")
	@NotNull
	private long permanentAddressId;

	public CustomerDetails() {
		super();
	}

	public CustomerDetails(long customerId, String customerName, long contactNumber, String dob, String gender,
			String occupation, long annualIncome, String emailId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.dob = dob;
		this.gender = gender;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.emailId = emailId;
	}

	public CustomerDetails(long customerId, String customerName, long contactNumber, String dob, String gender,
			String occupation, long annualIncome, String emailId, long residentialAddressId, long permanentAddressId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.dob = dob;
		this.gender = gender;
		this.occupation = occupation;
		this.annualIncome = annualIncome;
		this.emailId = emailId;
		this.residentialAddressId = residentialAddressId;
		this.permanentAddressId = permanentAddressId;
	}

	public long getResidentialAddressId() {
		return residentialAddressId;
	}

	public void setResidentialAddressId(long residentialAddressId) {
		this.residentialAddressId = residentialAddressId;
	}

	public long getPermanentAddressId() {
		return permanentAddressId;
	}

	public void setPermanentAddressId(long permanentAddressId) {
		this.permanentAddressId = permanentAddressId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public long getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(long annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "CustomerDetails [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", dob=" + dob + ", gender=" + gender + ", occupation=" + occupation
				+ ", annualIncome=" + annualIncome + ", emailId=" + emailId + ", residentialAddressId="
				+ residentialAddressId + ", permanentAddressId=" + permanentAddressId + "]";
	}

}