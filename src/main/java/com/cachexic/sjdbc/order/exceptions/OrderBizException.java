package com.cachexic.sjdbc.order.exceptions;


import com.cachexic.sjdbc.common.exceptions.BizException;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderBizException.java
 * @Package com.cachexic.sjdbc.order.exceptions
 * @Description: 订单业务异常
 * @date 2017-08-25 22:51:24
 */
public class OrderBizException extends BizException {
    /**
     * 构造方法
     * @param orderBizExceptionEnum
     */
    public OrderBizException(OrderBizExceptionEnum orderBizExceptionEnum){
        super(orderBizExceptionEnum.getCode(), orderBizExceptionEnum.getMsg());
    }
}
