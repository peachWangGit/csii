package com.csii.demo.query.api;

import java.io.Serializable;

public class QueryJnlRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8287305187768943024L;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
