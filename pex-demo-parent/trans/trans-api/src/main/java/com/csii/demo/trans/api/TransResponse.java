package com.csii.demo.trans.api;

import java.io.Serializable;

public class TransResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1843525465991625162L;
	private boolean isSuccess;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
}
