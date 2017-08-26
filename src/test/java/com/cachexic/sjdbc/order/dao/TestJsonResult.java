package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.core.Pagination;
import com.cachexic.sjdbc.common.core.Result;
import com.cachexic.sjdbc.common.exceptions.BizExceptionEnum;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.order.entity.Order;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by tangm on 2017/8/24.
 */
public class TestJsonResult {
    public static void main(String[] args) {
        Order order = new Order();
        order.setId(1L);

        //Result<Order>
        Result<Order> orderResult = Result.OK().setData(order);
        Order data = orderResult.getData();
        System.out.println(data.getId());

        List<Order> objects = Lists.newArrayList();
        objects.add(order);
        Order order2 = new Order();
        order2.setId(2L);
        objects.add(order2);
        //Result<List<Order>>
        Result<List<Order>> ordersResult = Result.OK().setData(objects);
        List<Order> data1 = ordersResult.getData();
        for (Order order1 : data1) {
            System.out.println(order1.getId());
        }
        System.out.println(JsonUtil.toJson(ordersResult));
        System.out.println("========================");


        Pagination<Order> orderPage = new Pagination<Order>(1L,10L,100L);
        orderPage.setList(data1);
        //Result<Pagination<Order>>
        Result<Pagination<Order>> pageResult = Result.FAIL(BizExceptionEnum.MD5_ERROR).setData(orderPage);
        Pagination<Order> data2 = pageResult.getData();
        List<Order> list = data2.getList();
        for (Order order1 : list) {
            System.out.println(order1.getId());
        }
        System.out.println(JsonUtil.toJson(pageResult));

    }
}
