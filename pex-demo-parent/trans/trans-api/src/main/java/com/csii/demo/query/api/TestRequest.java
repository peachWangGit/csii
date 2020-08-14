package com.csii.demo.query.api;

import java.io.Serializable;

public class TestRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8287305187768943024L;
	private String testRequest;

	public String getTestRequest() {
		return testRequest;
	}

	public void setTestRequest(String testRequest) {
		this.testRequest = testRequest;
	}

}
