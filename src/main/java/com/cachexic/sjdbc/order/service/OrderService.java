package com.cachexic.sjdbc.order.service;

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
}
