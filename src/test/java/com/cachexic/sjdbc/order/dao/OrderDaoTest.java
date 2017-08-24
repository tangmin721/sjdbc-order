package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.core.StatusEnum;
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
        Order order = new Order();
        order.setId(12L);
        order.setUserId(1L);
        order.setCreateUserId(1L);
        order.setStatus(StatusEnum.deleted);
        orderDao.insert(order);
    }

    @Test
    public void selectTest() throws Exception {
        System.out.println(orderDao.selectTest());
    }


}