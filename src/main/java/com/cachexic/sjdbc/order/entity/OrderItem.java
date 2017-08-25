package com.cachexic.sjdbc.order.entity;

import com.cachexic.sjdbc.common.core.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderItem.java
 * @Package com.cachexic.sjdbc.order.entity
 * @Description: 
 * @date 2017-08-24 16:50:07
 */
public class OrderItem {
    private Long id;
    private Long orderId;
    private Long eshopId;
    private String eshopName;
    private Long productId;
    private String productName;
    private BigDecimal actualPrice;

    private Integer version = 0;
    private StatusEnum status =StatusEnum.normal;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private Long createUserId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    private Long updateUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getEshopId() {
        return eshopId;
    }

    public void setEshopId(Long eshopId) {
        this.eshopId = eshopId;
    }

    public String getEshopName() {
        return eshopName;
    }

    public void setEshopName(String eshopName) {
        this.eshopName = eshopName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
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
