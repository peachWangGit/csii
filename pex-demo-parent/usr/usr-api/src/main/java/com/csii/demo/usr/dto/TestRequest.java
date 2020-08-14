package com.csii.demo.usr.dto;

import java.io.Serializable;

public class TestRequest implements Serializable {
	private static final long serialVersionUID = 8237075999721543960L;
	private String testParam;
	private String id;

	public String getTestParam() {
		return testParam;
	}

	public void setTestParam(String testParam) {
		this.testParam = testParam;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
