package com.cachexic.sjdbc.common.exceptions;

import com.cachexic.sjdbc.order.exceptions.OrderBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tangmin
 * @version V1.0
 * @Title: BizException.java
 * @Package com.cachexic.springboot.common.exceptions
 * @Description: 业务异常类，包装更多信息，比如code
 * 一定要继承RuntimeException。因为spring事务只有RuntimeException才会回滚
 * @date 2017-04-04 22:39:40
 */
public class BizException extends RuntimeException {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    private static final long serialVersionUID = -4968036951399076811L;

    /** 错误编码 */
    private int code;

    /** 默认错误编码 */
    private static final int DEFAULT_CODE = -1;

    /**
     * 构造方法
     *
     * @param bizExceptionEnum
     */
    public BizException(BizExceptionEnum bizExceptionEnum) {
        super(bizExceptionEnum.getMsg());
        this.code = bizExceptionEnum.getCode();
    }

    /**
     * 构造方法
     *
     * @param code
     * @param msg
     */
    public BizException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 构造方法(默认code)
     *
     * @param msg
     */
    public BizException(String msg) {
        this(DEFAULT_CODE, msg);
    }

    /**
     * 构造方法
     *
     * @param code
     * @param msg
     * @param args 支持表达式
     */
    public BizException(int code, String msg, Object... args) {
        super(String.format(msg, args));
        this.code = code;
    }

    /**
     * 构造方法(默认code)
     *
     * @param msg
     */
    public BizException(String msg, Object... args) {
        this(DEFAULT_CODE, msg, args);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static void main(String[] args) {
        try {
            if(1>0){
                throw new OrderBizException("%s:你是谁?%s回答:%s?", "aaa", "bbb", "啥");
            }else {
                throw new BizException("%s:你是谁?%s回答:%s?");
            }
        } catch (Exception e) {
            if (e instanceof BizException) {
                BizException ex = (BizException) e;
                log.warn("Exception class[{}],errorCode:[{}],message:[{}]", ex.getClass().getName(),ex.getCode(),e.getMessage());//短错误信息
                log.warn("-------------------------------------------------------------------------------------------------------");
                log.warn("Exception class[{}],errorCode:[{}],message:[{}]", e.getClass().getName(),ex.getCode(),e);//长错误信息
                log.warn("-------------------------------------------------------------------------------------------------------");
            }
        }

    }
}
