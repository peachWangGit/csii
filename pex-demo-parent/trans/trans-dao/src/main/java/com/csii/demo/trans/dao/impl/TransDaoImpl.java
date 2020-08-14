package com.csii.demo.trans.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientOperations;

import com.csii.demo.trans.bean.JTFBankInner;
import com.csii.demo.trans.bean.Mcjnl;
import com.csii.demo.trans.dao.inter.TransDao;

public class TransDaoImpl implements TransDao {
	private SqlMapClientOperations sqlMap;

	@Override
	public int insertMcJnl(Mcjnl mcjnl) {
		sqlMap.insert("trans.insertMcjnl", mcjnl);
		return 1;

	}

	@Override
	public List<JTFBankInner> queryJTFBankInner(String userid) {
		@SuppressWarnings("unchecked")
		List<JTFBankInner> list = (List<JTFBankInner>) sqlMap.queryForList("trans.queryJTFbankinner", userid);
		return list;
	}

	public JTFBankInner InsertJTFBankInner(JTFBankInner jtfBankInner) {
		JTFBankInner jTFBankInner = (JTFBankInner) sqlMap.insert("trans.insertJtfBankInner", jtfBankInner);
		return jTFBankInner;
	}

	public SqlMapClientOperations getSqlMap() {
		return sqlMap;
	}

	public void setSqlMap(SqlMapClientOperations sqlMap) {
		this.sqlMap = sqlMap;
	}

	@Override
	public JTFBankInner insertJTFBankInner(JTFBankInner jtfBankInner) {
		// TODO Auto-generated method stub
		return null;
	}

}
