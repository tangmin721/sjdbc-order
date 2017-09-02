package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.MybatisDao;
import com.cachexic.sjdbc.order.entity.Order;
import com.cachexic.sjdbc.order.entity.OrderAndItem;
import com.cachexic.sjdbc.order.entity.query.OrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface OrderDao {
    Long insert(Order order);
    Order selectById(@Param("id")Long id);

    List<Order> selectList();
    List<Order> selectTestOrderById();
    List<Order> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize")int pageSize);
    List<OrderAndItem> selectOrderLeftJoin();

    Long selectListTotal(OrderQuery query);
    List<Order> selectListPage(OrderQuery query);
}
