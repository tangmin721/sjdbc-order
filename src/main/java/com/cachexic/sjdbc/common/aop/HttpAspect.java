package com.cachexic.sjdbc.common.aop;

import com.cachexic.sjdbc.common.utils.json.JsonUtil;
import com.cachexic.sjdbc.common.utils.network.NetworkUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangmin
 * @version V1.0
 * @Title: HttpAspect.java
 * @Package com.cachexic.sjdbc.common.aop
 * @Description: Http拦截器
 * @date 2017-08-26 13:07:27
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 定义一个切面
     */
    @Pointcut("execution(public * com.cachexic.sjdbc.*.controller.*.*(..))")
    public void log(){
    }

    /**
     * 指定切面方法
     */
    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        logger.info("====> before controller ....");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("====> url={}",request.getRequestURL());
        logger.info("====> method={}",request.getMethod());
        logger.info("====> ip={},realIp={}",request.getRemoteAddr(), NetworkUtil.getIpAddress(request));
        //获取类名.方法
        logger.info("====> class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
        logger.info("====> args={}",JsonUtil.toJson(joinpoint.getArgs()));

    }

    @After("log()")
    public void doAfter(){
        logger.info("====> do after controller...");
    }

    /**
     * 获取切面方法返回结果
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void returning(Object object){
        logger.info("====> response={}", JsonUtil.toJson(object));
    }
}