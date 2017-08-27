package com.cachexic.sjdbc.order.service.impl;

import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.order.dao.OrderDao;
import com.cachexic.sjdbc.order.dao.OrderItemDao;
import com.cachexic.sjdbc.order.dao.TestOtherDsDao;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.OrderItem;
import com.cachexic.sjdbc.order.entity.TestOtherDs;
import com.cachexic.sjdbc.order.service.OrderService;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangm on 2017/8/25.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TestOtherDsDao testOtherDsDao;

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

    @Override
    @Transactional
    public void createOrderAndOtherDs(){
        Order order = new Order();
        order.setUserId(1L);
        order.setOrderSn(UUIDUtil.getUUID());
        order.setCreateUserId(1L);
        orderDao.insert(order);

        if(1==1){
            throw new RuntimeException("抛出异常");
        }

        TestOtherDs testOtherDs = new TestOtherDs();
        testOtherDs.setSeq(1);
        testOtherDsDao.insert(testOtherDs);

    }

    @Override
    public List<Order> hintManager() {
        //通过try语句释放资源
        try (HintManager hintManager = HintManager.getInstance()){
            //如果有读写分离，主库，则 强制读主库
            //hintManager.setMasterRouteOnly();

            //添加数据源分片键值(指定分库设置的shardingColumn，value:与他的id在同一个库)
            hintManager.addDatabaseShardingValue("t_order", "id", 108665268296744960L);

            //来添加表分片键值(指定分表设置的shardingColumn，value:与他的id在同一个表)
            hintManager.addTableShardingValue("t_order", "id", 108665268296744960L);
            //所以，查询出来的 都应该是本id对应的表
            return this.orderDao.selectTest();
        }
    }
}
