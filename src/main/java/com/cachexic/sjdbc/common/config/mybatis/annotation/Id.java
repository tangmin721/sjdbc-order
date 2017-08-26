package com.cachexic.sjdbc.common.config.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tangmin
 * @version V1.0
 * @Title: Field.java
 * @Package com.cachexic.sjdbc.common.config.mybatis.annotation
 * @Description: 标识主键id,用于代码生成
 * @date 2017-08-26 10:50:56
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
public @interface Id {
    
}
