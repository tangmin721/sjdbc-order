package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.MybatisDao;
import com.cachexic.sjdbc.order.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface MenuDao {
    int insert(Menu role);

    List<Menu> selectTest();
    List<Menu> selectTestOrderById();
    List<Menu> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize") int pageSize);
}
