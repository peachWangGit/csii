package com.csii.demo.sim.action;

import com.csii.pe.action.Action;
import com.csii.pe.action.Executable;
import com.csii.pe.core.Context;
import com.csii.pe.core.PeException;

public class TestSimAction implements Action, Executable {

	@Override
	public void execute(Context context) throws PeException {
		Integer id = context.getInteger("Id");
		String testParam = context.getString("TestParam");
		System.out.println(id);
		System.out.println(testParam);
		
		context.setData("ResultParam", "123456");
	}

}
