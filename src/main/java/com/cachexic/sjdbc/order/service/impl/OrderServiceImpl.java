package com.cachexic.sjdbc.order.service.impl;

import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.order.dao.OrderDao;
import com.cachexic.sjdbc.order.dao.OrderItemDao;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.OrderItem;
import com.cachexic.sjdbc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tangm on 2017/8/25.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    @Transactional
    public void createOrder() {
        for(long i=1;i<11;i++){
            Order order = new Order();
            order.setUserId(i);
            order.setOrderSn(UUIDUtil.getUUID());
            order.setCreateUserId(i);
            orderDao.insert(order);

//            if(i==8){
//                throw new RuntimeException("=8时抛出异常");
//            }

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setOrderId(order.getId());
            orderItem1.setEshopId(i);
            orderItem1.setProductId(i);
            orderItem1.setProductName("商品"+i);
            orderItem1.setCreateUserId(i);
            orderItemDao.insert(orderItem1);
        }
    }
}
