package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.MybatisDao;
import com.cachexic.sjdbc.order.entity.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface OrderItemDao {
    Long insert(OrderItem orderItem);

    List<OrderItem> selectTest();
    List<OrderItem> selectTestOrderById();
    List<OrderItem> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize") int pageSize);
}
