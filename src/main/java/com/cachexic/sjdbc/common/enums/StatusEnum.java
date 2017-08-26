package com.cachexic.sjdbc.common.enums;

import com.cachexic.sjdbc.common.vo.ValueMemoVo;

import java.util.ArrayList;
import java.util.List;

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
        List list = new ArrayList();
        for (StatusEnum _enum : StatusEnum.values()) {
            ValueMemoVo valueMemoVo = new ValueMemoVo();
            valueMemoVo.setValue(_enum.getValue());
            valueMemoVo.setMemo(_enum.getMemo());
            list.add(valueMemoVo);
        }
        return list;
    }

}
