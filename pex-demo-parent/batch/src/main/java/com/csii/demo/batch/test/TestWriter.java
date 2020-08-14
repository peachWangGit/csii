package com.csii.demo.batch.test;

import com.csii.demo.batch.test.dao.TestDao;
import com.csii.demo.batch.test.dao.Trans;
import lombok.Setter;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by darkstar on 2017/11/29.
 */
public class TestWriter implements ItemWriter<Trans> {

    @Setter
    private TestDao testDao;

    @Override
    public void write(List<? extends Trans> list) throws Exception {
        for (Trans trans:list){

            testDao.insert(trans);

        }
    }
}
