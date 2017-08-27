package com.cachexic.sjdbc.order.entity;

import com.cachexic.sjdbc.common.core.BaseEntity;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Role.java
 * @Package com.cachexic.sjdbc.order.entity
 * @Description: 测试mysql自动生成主键,并测试不设置分片规则的情况
 * @date 2017-08-27 21:27:33
 */
public class Role extends BaseEntity{


    private Integer seq;


    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }
}
