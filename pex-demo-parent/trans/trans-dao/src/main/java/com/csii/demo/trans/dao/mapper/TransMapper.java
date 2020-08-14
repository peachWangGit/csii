package com.csii.demo.trans.dao.mapper;

import com.csii.demo.trans.bean.JTFBankInner;
import com.csii.demo.trans.bean.Mcjnl;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: PEX
 * @Date: 2019/7/9 13:45
 * @Author: Li Tangjian
 * @Description:
 */
public interface TransMapper {

    int insertMcjnl(@Param("mcjnl")Mcjnl mcjnl);

    List<JTFBankInner> queryJTFbankinner(@Param("userid")String userid);

    int insertJtfBankInner(@Param("jtfBankInner")JTFBankInner jtfBankInner);

}
