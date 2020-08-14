package com.csii.demo.usr.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.csii.demo.usr.bean.Test;

public interface TestMapper {
	Test queryTest(@Param("id") Integer id);
}
