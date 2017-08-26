package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.MybatisDao;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.OrderAndItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface OrderDao {
    Long insert(Order order);

    List<Order> selectTest();
    List<Order> selectTestOrderById();
    List<Order> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize")int pageSize);
    List<OrderAndItem> selectOrderLeftJoin();
}
