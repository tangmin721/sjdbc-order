package com.cachexic.sjdbc.order.entity;

import com.cachexic.sjdbc.common.core.BaseEntity;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Menu.java
 * @Package com.cachexic.sjdbc.order.entity
 * @Description: 测试跨机器数据源事务，读写分离
 * @date 2017-08-28 17:00:16
 */
public class Menu extends BaseEntity{


    private Integer seq;


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
