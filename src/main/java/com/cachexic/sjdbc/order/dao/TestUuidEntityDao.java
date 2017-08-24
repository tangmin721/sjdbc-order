package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.MybatisDao;
import com.cachexic.sjdbc.order.entity.TestUuidEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface TestUuidEntityDao {
    int insert(TestUuidEntity order);

    List<TestUuidEntity> selectTest();
    List<TestUuidEntity> selectTestOrderById();
    List<TestUuidEntity> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize") int pageSize);
}
