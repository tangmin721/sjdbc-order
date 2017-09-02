package com.cachexic.sjdbc.order;

import com.cachexic.sjdbc.common.exceptions.BizPreconditions;
import com.cachexic.sjdbc.order.entity.Order;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.Collections;
import java.util.Date;
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

        Comparable<?> value = Boolean.FALSE;
        BizPreconditions.checkArgument(value instanceof Number || value instanceof Date || value instanceof String,
                "Value must be type of Number, Data or String, your value type is '%s'", value.getClass().getName());

        boolean nullOrEmpty = Strings.isNullOrEmpty("");
        System.out.println(nullOrEmpty);

        String nameStr = null;
        String name = BizPreconditions.checkNotNull(nameStr,"name不能为空");

        BizPreconditions.checkNotNull(null,"%s空指针异常",1);

        BizPreconditions.checkArgument(!stringOrderMap.isEmpty(),"int %s",1);
        BizPreconditions.checkArgument(!stringOrderMap.isEmpty());


        Preconditions.checkArgument(!stringOrderMap.isEmpty() || !stringOrderMap.isEmpty(), "Sharding JDBC: No data source config");

    }
}
