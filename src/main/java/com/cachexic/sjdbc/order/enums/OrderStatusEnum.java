package com.cachexic.sjdbc.order.enums;

import com.cachexic.sjdbc.common.vo.ValueDescVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderStatusEnum.java
 * @Package com.cachexic.sjdbc.order.enums
 * @Description: 订单状态
 * @date 2017-08-25 22:58:48
 */
public enum OrderStatusEnum {

    ordered("ordered","已下单"),
    waitPay("waitPay","待支付"),
    paid("paid","已支付"),
    shipped("shipped","已发货"),
    waitDispatch("waitDispatch","待派单"),
    received("received","已接单"),
    started("started","已出发"),
    signed("signed","已签收"),
    inService("inService","服务中"),
    commented("commented","已点评"),
    completed("completed","已完成"),
    cancelled("cancelled","已取消");


    private final String value;
    private final String desc;

    OrderStatusEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public static OrderStatusEnum getByValue(String value) {
        if (null == value)
            return null;
        for (OrderStatusEnum _enum : OrderStatusEnum.values()) {
            if (value.equals(_enum.getValue()))
                return _enum;
        }
        return null;
    }

    /**
     * 转换为list
     * @return
     */
    public static List toList() {
        List list = new ArrayList();
        for (OrderStatusEnum _enum : OrderStatusEnum.values()) {
            ValueDescVo valueDescVo = new ValueDescVo();
            valueDescVo.setValue(_enum.getValue());
            valueDescVo.setDesc(_enum.getDesc());
            list.add(valueDescVo);
        }
        return list;
    }
}
