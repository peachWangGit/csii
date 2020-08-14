package com.csii.demo.usr.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.csii.demo.usr.bean.Test;
import com.csii.demo.usr.dao.inter.TestDao;
import com.csii.demo.usr.dao.inter.UserDao;
import com.csii.demo.usr.dao.mapper.TestMapper;
import com.csii.demo.usr.dao.mapper.UserMapper;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class TestAction extends BaseQueryAction {
	
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private TestDao testDao;
	
	@Override
	public void execute(Context context) throws PeException {
		String testParam = context.getString("TestParam");
		Integer integer = context.getInteger("Id");
		
		Test test2 = new Test();
		test2.setId(integer);
		test2.setTestParam(testParam);
		
//		Test test = testMapper.queryTest(integer);
		Test test = testDao.query(test2);
		
		context.setData("TestResult", test.getTestParam());
		context.setData("Id", test.getId());
	}

//	public TestDao getTestDao() {
//		return testDao;
//	}
//
//	public void setTestDao(TestDao testDao) {
//		this.testDao = testDao;
//	}
	
	
}
