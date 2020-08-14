package com.csii.demo.trans.bean;

import java.io.Serializable;

public class JTFBankInner extends BaseInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -857653412399368748L;
	private String jnlNo;
	private String payerAcNo;
	private String payeeAcNo;
	private String amount;
	private String fundUsage;
	
	
	public String getJnlNo() {
		return jnlNo;
	}

	public void setJnlNo(String jnlNo) {
		this.jnlNo = jnlNo;
	}

	public String getPayerAcNo() {
		return payerAcNo;
	}

	public void setPayerAcNo(String payerAcNo) {
		this.payerAcNo = payerAcNo;
	}

	public String getPayeeAcNo() {
		return payeeAcNo;
	}

	public void setPayeeAcNo(String payeeAcNo) {
		this.payeeAcNo = payeeAcNo;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFundUsage() {
		return fundUsage;
	}

	public void setFundUsage(String fundUsage) {
		this.fundUsage = fundUsage;
	}
	

}
