package com.cachexic.sjdbc.common.core;

/**
 * Created by tangm on 2017/8/20.
 */
public enum StatusEnum {
    deleted("deleted","删除"),
    normal("normal","正常");

    private final String value;
    private final String description;

    StatusEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return description;
    }

    public static StatusEnum getByValue(String value) {
        if (null == value)
            return null;
        for (StatusEnum _enum : StatusEnum.values()) {
            if (value.equals(_enum.getValue()))
                return _enum;
        }
        return null;
    }
}
