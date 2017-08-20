package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.MybatisDao;
import com.cachexic.sjdbc.order.entity.Order;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface OrderDao {
    int insert(Order order);

    long selectTest();
}
