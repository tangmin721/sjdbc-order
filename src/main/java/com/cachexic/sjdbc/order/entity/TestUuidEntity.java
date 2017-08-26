package com.cachexic.sjdbc.order.entity;

import com.cachexic.sjdbc.common.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 * @Title: TestUuidEntity.java
 * @Package com.cachexic.sjdbc.order.entity
 * @Description: 测试uuid分库分表策略
 * @date 2017-08-24 23:22:46
 */
public class TestUuidEntity {

    /** uuid */
    private String id;
    private Integer seq;

    private Integer version = 0;
    private StatusEnum status =StatusEnum.normal;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private Long createUserId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private Long updateUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }
}
