package com.csii.demo.batch.test;

import com.csii.demo.batch.test.dao.Trans;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by darkstar on 2017/11/29.
 */
public class TestProcessor implements ItemProcessor<Trans,Trans> {
    @Override
    public Trans process(Trans trans) throws Exception {

        Trans transresult = new Trans();
        transresult.setId(trans.getId()*2);
        transresult.setStatus(trans.getStatus());
        return transresult;
    }
}
