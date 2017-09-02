package com.cachexic.sjdbc.order.controller;

import com.cachexic.sjdbc.common.core.Result;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.order.dao.MenuDao;
import com.cachexic.sjdbc.order.entity.Menu;
import com.cachexic.sjdbc.order.entity.Order;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private MenuDao menuDao;

    //@RequestMapping(value = {"test","test1","test2"},method = RequestMethod.GET)   配置多种路径都访问同一个方法
    // @RequestMapping("/test",method = RequestMethod.GET)
    @GetMapping("getOrderById")
    public String  getOrderById(){
        Order order = new Order();
        order.setOrderSn("123456");
        order.setCreateTime(new Date());
        order.setUserId(1L);

        String json = JsonUtil.toJson(order);
        Order order1 = JsonUtil.toEntity(json, Order.class);
        System.out.println("getOrderById::"+ JsonUtil.toJson(order1));

        return json;
    }

    @GetMapping("result")
    @ResponseBody
    public Result result(){
        Preconditions.checkArgument(1==0);
        return Result.OK();
    }

    @GetMapping("getOrderList")
    public String  getOrderList(){
        List<Object> orders = Lists.newArrayList();
        Order order = new Order();
        order.setOrderSn("123456");
        order.setCreateTime(new Date());
        order.setUserId(1L);
        orders.add(order);

        Order order1 = new Order();
        order1.setOrderSn("223456");
        order1.setCreateTime(new Date());
        order1.setUserId(2L);
        orders.add(order1);

        String json = JsonUtil.toJson(orders);

        List<Order> orders1 = JsonUtil.toList(json, Order.class);
        System.out.println("getOrderList:::"+ JsonUtil.toJson(orders1));

        List<Menu> object = null;
        try (HintManager hintManager = HintManager.getInstance()){
            hintManager.setMasterRouteOnly();//强制读主库
            object = menuDao.selectTest();
            System.out.println(JsonUtil.toJson(object));
            System.out.println(object.size());
        }

        return JsonUtil.toJson(object);
    }

}