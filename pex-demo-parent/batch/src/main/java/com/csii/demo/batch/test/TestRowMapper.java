package com.csii.demo.batch.test;

import com.csii.demo.batch.test.dao.Trans;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by darkstar on 2017/11/29.
 */
public class TestRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Trans trans = new Trans();
        trans.setId(resultSet.getInt("id"));
        trans.setStatus("Y");
        return trans;
    }
}
