package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class OrderDaoTest extends JunitTestParent {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

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


    @Test
    public void insert() throws Exception {

        for(long i=1;i<11;i++){
            Order order = new Order();
            order.setUserId(i);
            order.setOrderSn(UUIDUtil.getUUID());
            order.setCreateUserId(i);
            orderDao.insert(order);

//            OrderItem orderItem1 = new OrderItem();
//            orderItem1.setOrderId(order.getId());
//            orderItem1.setEshopId(i);
//            orderItem1.setProductId(i);
//            orderItem1.setProductName("1商品"+i);
//            orderItem1.setCreateUserId(i);
//            orderItemDao.insert(orderItem1);
//
//            OrderItem orderItem2 = new OrderItem();
//            orderItem2.setOrderId(order.getId());
//            orderItem2.setEshopId(i);
//            orderItem2.setProductId(i);
//            orderItem2.setProductName("2商品"+i);
//            orderItem2.setCreateUserId(i);
//            orderItemDao.insert(orderItem2);
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