package com.cachexic.sjdbc.order;

import com.cachexic.sjdbc.order.entity.Order;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.Collections;
import java.util.Map;

/**
 * @author tangmin
 * @version V1.0
 * @Title: TestMainShardingJdbc.java
 * @Package com.cachexic.sjdbc.order
 * @Description: sharding jdbc源码解读
 * @date 2017-09-01 22:57:36
 */
public class TestMainShardingJdbc {
    public static void main(String[] args) {
        //定义空map
        Map<String, Order> stringOrderMap = Collections.<String, Order>emptyMap();
        //判断map是否空
        System.out.println(stringOrderMap.isEmpty());//true
        System.out.println(stringOrderMap==null);//false

        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        System.out.println(nullOrEmpty);

        String nameStr = null;
        String name = com.cachexic.sjdbc.common.exceptions.Preconditions.checkNotNull(nameStr,"name不能为空");

        com.cachexic.sjdbc.common.exceptions.Preconditions .checkNotNull(null,"%s空指针异常",1);

        com.cachexic.sjdbc.common.exceptions.Preconditions .checkArgument(!stringOrderMap.isEmpty(),"int %s",1);
        com.cachexic.sjdbc.common.exceptions.Preconditions .checkArgument(!stringOrderMap.isEmpty());


        Preconditions.checkArgument(!stringOrderMap.isEmpty() || !stringOrderMap.isEmpty(), "Sharding JDBC: No data source config");

    }
}
