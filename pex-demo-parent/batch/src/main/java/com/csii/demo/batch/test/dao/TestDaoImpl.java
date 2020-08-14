package com.csii.demo.batch.test.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.orm.ibatis.SqlMapClientOperations;

/**
 * Created by darkstar on 2017/11/29.
 */
public class TestDaoImpl implements TestDao {

    @Setter
    @Getter
     private SqlMapClientOperations sqlMap;

    public void insert(Trans trans){
         sqlMap.insert("test.insertTrans",trans);
    }

}
