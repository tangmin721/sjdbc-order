package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.MybatisDao;
import com.cachexic.sjdbc.order.entity.TestOtherDs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface TestOtherDsDao {
    int insert(TestOtherDs order);

    List<TestOtherDs> selectTest();
    List<TestOtherDs> selectTestOrderById();
    List<TestOtherDs> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize") int pageSize);
}
