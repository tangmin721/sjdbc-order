package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.MybatisDao;
import com.cachexic.sjdbc.order.entity.Order;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface OrderDao {
    long insert(Order order);

    List<Long> selectTest();
}
