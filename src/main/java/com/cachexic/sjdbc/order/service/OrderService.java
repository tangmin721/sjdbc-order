package com.cachexic.sjdbc.order.service;

import com.cachexic.sjdbc.order.entity.Order;

import java.util.List;

/**
 * Created by tangm on 2017/8/25.
 */
public interface OrderService {

    Long insert(Order order);

    List<Order> selectList();

    /**
     * 测试事务
     */
    void createOrder();

    /**
     * 测试同机器不同数据源的事务
     */
    void createOrderAndOtherDs();


    /**
     * 测试不同机器不同数据源的事务
     */
    void createOrderAndMenu();

    /**
     * 测试强制路由
     */
    List<Order> hintManager();

    /**
     * 测试定时调度方法
     */
    void scheduleMethod();
}
