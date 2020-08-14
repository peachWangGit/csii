package com.csii.demo.usr.dto;

import java.io.Serializable;

public class TestResponse implements Serializable {

	private static final long serialVersionUID = 3645741701998580583L;
	private String testResult;
	private String id;

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
