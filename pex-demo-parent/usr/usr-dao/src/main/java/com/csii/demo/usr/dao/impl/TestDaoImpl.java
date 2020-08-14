package com.csii.demo.usr.dao.impl;

import org.springframework.orm.ibatis.SqlMapClientOperations;

import com.csii.demo.usr.bean.Test;
import com.csii.demo.usr.dao.inter.TestDao;

public class TestDaoImpl implements TestDao {
	
	private SqlMapClientOperations sqlMap;

	@Override
	public Test query(Test test) {
		Test test2 = (Test)sqlMap.queryForObject("test.queryTest", test);
		return test2;
	}

	public SqlMapClientOperations getSqlMap() {
		return sqlMap;
	}

	public void setSqlMap(SqlMapClientOperations sqlMap) {
		this.sqlMap = sqlMap;
	}

}
