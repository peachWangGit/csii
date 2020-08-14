package com.csii.demo.query.api;

import java.io.Serializable;
import java.util.List;

import com.csii.demo.trans.bean.JTFBankInner;

public class QueryJnlResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9014513987886739006L;

	private List<JTFBankInner> List;

	public List<JTFBankInner> getList() {
		return List;
	}

	public void setList(List<JTFBankInner> list) {
		List = list;
	}

}
