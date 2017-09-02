package com.cachexic.sjdbc.order.service.impl;

import com.cachexic.sjdbc.common.core.Pagination;
import com.cachexic.sjdbc.common.exceptions.BizException;
import com.cachexic.sjdbc.common.exceptions.BizExceptionEnum;
import com.cachexic.sjdbc.common.utils.UUIDUtil;
import com.cachexic.sjdbc.common.utils.json.JsonMapper;
import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.order.dao.MenuDao;
import com.cachexic.sjdbc.order.dao.OrderDao;
import com.cachexic.sjdbc.order.dao.OrderItemDao;
import com.cachexic.sjdbc.order.dao.TestOtherDsDao;
import com.cachexic.sjdbc.order.entity.Menu;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.OrderItem;
import com.cachexic.sjdbc.order.entity.TestOtherDs;
import com.cachexic.sjdbc.order.entity.query.OrderQuery;
import com.cachexic.sjdbc.order.service.OrderService;
import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tangm on 2017/8/25.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
    protected static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TestOtherDsDao testOtherDsDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private MenuDao menuDao;

    @Override
    public Long insert(Order order) {
        Long insert = this.orderDao.insert(order);
        if (insert <= 0) {
            throw new BizException(BizExceptionEnum.DB_INSERT_RESULT_0);
        }
        log.info("{}==>insert entity-->{}", order.getClass(), JsonMapper.nonNullMapper().toJson(order));
        return order.getId();
    }

    @Override
    public List<Order> selectList() {
        return this.orderDao.selectList();
    }

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

//        if(1==1){
//            throw new RuntimeException("抛出异常");
//        }

        TestOtherDs testOtherDs = new TestOtherDs();
        testOtherDs.setSeq(1);
        testOtherDsDao.insert(testOtherDs);

    }

    @Override
    @Transactional
    public void createOrderAndMenu() {
        Order order = new Order();
        order.setUserId(1L);
        order.setOrderSn(UUIDUtil.getUUID());
        order.setCreateUserId(1L);
        orderDao.insert(order);

        Menu menu = new Menu();
        menu.setSeq(1);
        menuDao.insert(menu);

        Order order2 = new Order();
        order2.setUserId(2L);
        order2.setOrderSn(UUIDUtil.getUUID());
        order2.setCreateUserId(2L);
        orderDao.insert(order2);

        if(1==1){
            throw new RuntimeException("抛出异常");
        }
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
            return this.orderDao.selectList();
        }
    }

    /**
     * 每两秒执行一次
     */
    @Override
    @Scheduled(fixedRate=2000)
    public void scheduleMethod() {
        System.out.println(JsonUtil.toJson(this.orderDao.selectList()));
    }

    @Override
    public Pagination<Order> selectPagination(OrderQuery query) {
        long total = this.orderDao.selectListTotal(query);
        Pagination<Order> pagination = new Pagination<>(query.getCurrentPage(), query.getPageSize(),total);
        if(total>0){
            pagination.setList(this.orderDao.selectListPage(query));
        }
        return pagination;
    }
}
