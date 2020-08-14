package com.csii.demo.trans.api;

import java.io.Serializable;

public class TransRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -830017220592766599L;
	
	private String jnlNo;
	private String Amount;
	
	public String getJnlNo() {
		return jnlNo;
	}
	public void setJnlNo(String jnlNo) {
		this.jnlNo = jnlNo;
	}
	public String getAmount() {
		return Amount;
	}
	public void setAmount(String amount) {
		Amount = amount;
	}





    
	
}
