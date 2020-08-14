package com.csii.demo.trans.dao.inter;

import java.util.List;

import com.csii.demo.trans.bean.JTFBankInner;
import com.csii.demo.trans.bean.Mcjnl;

public interface TransDao {
	public int insertMcJnl(Mcjnl mcjnl);
	public List<JTFBankInner>  queryJTFBankInner(String userid);
	public JTFBankInner insertJTFBankInner(JTFBankInner jtfBankInner);
}
