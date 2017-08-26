package com.cachexic.sjdbc.order.exceptions;

/**
 * @author ylw
 * @version V1.0
 * @Title: UserBizExceptionEnum.java
 * @Package com.cachexic.springboot.common.exceptions.enums
 * @Description: 订单模块异常定义
 * @date 2017-05-23
 */
public enum OrderBizExceptionEnum {

    CREATE_ORDER_FAIL(-1,"创建订单失败");

    private int code;
    private String msg;

    /**
     * 构造方法
     * @param code
     * @param msg
     */
    OrderBizExceptionEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
