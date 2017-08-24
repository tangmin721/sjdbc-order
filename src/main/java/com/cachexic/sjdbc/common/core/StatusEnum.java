package com.cachexic.sjdbc.common.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tangmin
 * @version V1.0
 * @Title: StatusEnum.java
 * @Package com.cachexic.sjdbc.common.core
 * @Description: 每条数据库记录的状态 枚举
 * @date 2017-08-24 22:46:57
 */
public enum StatusEnum {

    normal("normal","正常"),
    deleted("deleted","删除"),
    disabled("disabled","禁用"),
    frozen("frozen","冻结");

    private final String value;
    /** 备注信息 */
    private final String memo;

    StatusEnum(String value, String memo) {
        this.value = value;
        this.memo = memo;
    }

    public String getValue() {
        return value;
    }

    public String getMemo() {
        return memo;
    }

    /**
     * 根据值获取枚举
     * @param value
     * @return
     */
    public static StatusEnum getByValue(String value) {
        if (null == value)
            return null;
        for (StatusEnum _enum : StatusEnum.values()) {
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
        StatusEnum[] ary = StatusEnum.values();
        List list = new ArrayList();
        for (int i = 0; i < ary.length; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("value", ary[i].getValue());
            map.put("memo", ary[i].getMemo());
            list.add(map);
        }
        return list;
    }
}
