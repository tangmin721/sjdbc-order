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

    /**
     * 统一异常处理，异常定义
     */
    public final static int SYS_EX_CODE = -1;
    public final static String SYS_EX_MSG = "操作异常";

    /**
     * feign_fallback消息
     */
    public final static int FEIGN_FALLBACK_CODE = -1;

    public static final String FEIGN_FALLBACK_MSG = "feign回调失败:";

    private SystemConst() {
        throw new IllegalAccessError("Utility class");
    }
}