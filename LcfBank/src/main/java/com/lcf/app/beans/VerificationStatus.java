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
@Table(name = "VERIFICATION_STATUS")
public class VerificationStatus {

	@Id
	@Column(name = "REFERENCE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HB_REF_SEQ")
	@SequenceGenerator(name = "HB_REF_SEQ", sequenceName = "ReferenceId_Sequence", allocationSize = 19)
	private long referenceId;

	@Column(name = "CUSTOMER_ID")
	@NotNull
	private long customerId;

	@Column(name = "VERIFIED")
	@NotNull
	private char verified = 'N';

	public long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(long referenceId) {
		this.referenceId = referenceId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public char getVerified() {
		return verified;
	}

	public void setVerified(char verified) {
		this.verified = verified;
	}

	public VerificationStatus(long referenceId, long customerId, char verified) {
		super();
		this.referenceId = referenceId;
		this.customerId = customerId;
		this.verified = verified;
	}

	public VerificationStatus() {
		super();
	}

	@Override
	public String toString() {
		return "VerificationStatus [referenceId=" + referenceId + ", customerId=" + customerId + ", verified="
				+ verified + "]";
	}

}
