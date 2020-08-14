package com.csii.demo.batch.test.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by darkstar on 2017/11/29.
 */
@Data
public class Trans implements Serializable {
    private static final long serialVersionUID = -1807284883288578895L;
    private int id;
    private String status;

}
