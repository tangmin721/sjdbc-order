package com.cachexic.sjdbc.order.service.impl;

import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by tangm on 2017/8/29.
 */
@ActiveProfiles("dev")
public class OrderServiceImplTest extends JunitTestParent{
    @Autowired
    private OrderService orderService;

    /**
     * 测试事务
     * @throws Exception
     */
    @Test
    public void createOrder() throws Exception {
        orderService.createOrder();
    }

    /**
     * 测试跨库事务
     * @throws Exception
     */
    @Test
    public void createOrderAndOtherDs() throws Exception {
        orderService.createOrderAndOtherDs();
    }

    /**
     * 测试强制路由
     * @throws Exception
     */
    @Test
    public void hintManager() throws Exception {
        System.out.println(JsonUtil.toJson(orderService.hintManager()));
    }

}