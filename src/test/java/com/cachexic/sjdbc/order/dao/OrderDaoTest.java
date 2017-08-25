package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.OrderItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class OrderDaoTest extends JunitTestParent {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Test
    public void insert() throws Exception {

        for(long i=1;i<11;i++){
            Order order = new Order();
            order.setUserId(i);
            order.setOrderSn(UUIDUtil.getUUID());
            order.setCreateUserId(i);
            orderDao.insert(order);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setOrderId(order.getId());
            orderItem1.setEshopId(i);
            orderItem1.setProductId(i);
            orderItem1.setProductName("商品"+i);
            orderItem1.setCreateUserId(i);
            orderItemDao.insert(orderItem1);
        }
    }

    @Test
    public void selectTest() throws Exception {
        System.out.println(JsonUtil.toJson(orderDao.selectTest()));
    }

    @Test
    public void selectTestOrderById() throws Exception {
        System.out.println(JsonUtil.toJson(orderDao.selectTestOrderById()));
    }

    @Test
    public void selectTestOrderByIdLimit() throws Exception {
        System.out.println(JsonUtil.toJson(orderDao.selectTestOrderByIdLimit(0L,10)));
    }

    @Test
    public void selectOrderLeftJoin() throws Exception {
        System.out.println(JsonUtil.toJson(orderDao.selectOrderLeftJoin()));
    }

}