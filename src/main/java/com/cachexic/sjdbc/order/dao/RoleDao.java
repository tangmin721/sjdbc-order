package com.cachexic.sjdbc.order.dao;

import com.cachexic.sjdbc.common.config.mybatis.annotation.MybatisDao;
import com.cachexic.sjdbc.order.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tangm on 2017/8/20.
 */
@MybatisDao
public interface RoleDao {
    int insert(Role role);

    List<Role> selectTest();
    List<Role> selectTestOrderById();
    List<Role> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize") int pageSize);
}
