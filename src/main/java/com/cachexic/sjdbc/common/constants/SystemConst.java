package com.cachexic.sjdbc.common.constants;

/**
 * @author tangmin
 * @version V1.0
 * @Title: SystemConst.java
 * @Package com.cachexic.sjdbc.common.constants
 * @Description: 系统常量
 * @date 2017-08-26 12:19:36
 */
public class SystemConst {
    public static final long DEFAULT_PAGE_SIZE = 10;
    public static final long MAX_PAGE_SIZE = 50;

    private SystemConst() {
        throw new IllegalAccessError("Utility class");
    }
}
