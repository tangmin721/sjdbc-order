package com.cachexic.sjdbc.order.entity;

import java.math.BigDecimal;

/**
 * Created by tangm on 2017/8/25.
 */
public class OrderAndItem {
    private Long userId;
    private String orderSn;
    private BigDecimal totalActualPrice;

    private Long orderId;
    private Long orderItemOrderId;
    private Long orderItemId;
    private Long eshopId;
    private String eshopName;
    private Long productId;
    private String productName;
    private BigDecimal actualPrice;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public BigDecimal getTotalActualPrice() {
        return totalActualPrice;
    }

    public void setTotalActualPrice(BigDecimal totalActualPrice) {
        this.totalActualPrice = totalActualPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemOrderId() {
        return orderItemOrderId;
    }

    public void setOrderItemOrderId(Long orderItemOrderId) {
        this.orderItemOrderId = orderItemOrderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
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
}
