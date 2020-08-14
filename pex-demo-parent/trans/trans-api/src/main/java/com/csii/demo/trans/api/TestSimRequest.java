package com.csii.demo.trans.api;

import java.io.Serializable;

public class TestSimRequest implements Serializable {
	private static final long serialVersionUID = -7093469460734254724L;
	private Integer id;
	private String testParam;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestParam() {
		return testParam;
	}
	public void setTestParam(String testParam) {
		this.testParam = testParam;
	}
	
}
