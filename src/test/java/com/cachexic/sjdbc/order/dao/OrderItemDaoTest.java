package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.junit.JunitTestParent;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by tangm on 2017/8/20.
 */
@ActiveProfiles("dev")
public class OrderItemDaoTest extends JunitTestParent {

    @Autowired
    private OrderItemDao orderItemDao;

    @Test
    public void selectTest() throws Exception {
        System.out.println(JsonUtil.toJson(orderItemDao.selectTest()));
    }

    @Test
    public void selectTestOrderById() throws Exception {
        System.out.println(JsonUtil.toJson(orderItemDao.selectTestOrderById()));
    }

    @Test
    public void selectTestOrderByIdLimit() throws Exception {
        System.out.println(JsonUtil.toJson(orderItemDao.selectTestOrderByIdLimit(0L,10)));
    }



}