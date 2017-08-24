package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.junit.JunitTestParent;
import com.cachexic.sjdbc.order.entity.Order;
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

    @Test
    public void insert() throws Exception {

        for(long i=1;i<100;i++){
            Order order = new Order();
            order.setId(i);
            order.setUserId(i);
            order.setOrderSn(UUIDUtil.getUUID());
            order.setCreateUserId(i);
            orderDao.insert(order);
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

}