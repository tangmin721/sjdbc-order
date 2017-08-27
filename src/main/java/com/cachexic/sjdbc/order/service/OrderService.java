package com.cachexic.sjdbc.order.service;

import com.cachexic.sjdbc.order.entity.Order;

import java.util.List;

/**
 * Created by tangm on 2017/8/25.
 */
public interface OrderService {

    /**
     * 测试事务
     */
    void createOrder();

    /**
     * 测试不同数据源的事务
     */
    void createOrderAndOtherDs();

    /**
     * 测试强制路由
     */
    List<Order> hintManager();
}