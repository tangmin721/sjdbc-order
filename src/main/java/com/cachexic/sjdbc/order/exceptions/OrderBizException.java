package com.cachexic.sjdbc.order.exceptions;


import com.cachexic.sjdbc.common.exceptions.BizException;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderBizException.java
 * @Package com.cachexic.sjdbc.order.exceptions
 * @Description: 订单业务异常  .（业务异常都抛出默认code）。
 * @date 2017-08-25 22:51:24
 */
public class OrderBizException extends BizException {

    /**
     * 构造方法
     *
     * @param orderBizExceptionEnum
     */
    public OrderBizException(OrderBizExceptionEnum orderBizExceptionEnum) {
        super(orderBizExceptionEnum.getCode(), orderBizExceptionEnum.getMsg());
    }

    /**
     * 构造方法
     *
     * @param msg
     */
    public OrderBizException(String msg) {
        super(msg);
    }

    /**
     * 构造方法
     *
     * @param msg
     * @param args
     */
    public OrderBizException(String msg, Object... args) {
        super(msg, args);
    }
}
