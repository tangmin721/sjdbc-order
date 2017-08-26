package com.cachexic.sjdbc.common.core;

import com.cachexic.sjdbc.common.config.mybatis.annotation.Field;
import com.cachexic.sjdbc.common.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 * @Title: BaseEntity.java
 * @Package com.cachexic.sjdbc.common.core
 * @Description: 带有管理信息的基础实例类
 * @date 2017-08-26 12:39:32
 */
public class BaseEntity extends PojoBaseEntity {

    @Field(value = "乐观锁版本号",defaultValue = "0")
    private Integer version = 0;

    @Field(value = "状态",defaultValue ="normal")
    private StatusEnum status =StatusEnum.normal;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    private Long createUserId;

    private String createUserName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private Long updateUserId;

    private String updateUserName;


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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
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

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }
}
