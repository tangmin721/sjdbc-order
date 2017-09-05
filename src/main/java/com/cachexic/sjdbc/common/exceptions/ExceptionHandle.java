package com.cachexic.sjdbc.common.exceptions;

import com.cachexic.sjdbc.common.constants.SystemConst;
import com.cachexic.sjdbc.common.core.Result;
import com.cachexic.sjdbc.common.utils.network.IpAddressUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangmin
 * @version V1.0
 * @Title: ExceptionHandle.java
 * @Package com.cachexic.sjdbc.common.exceptions
 * @Description: 统一异常处理
 * @date 2017-08-26 13:16:32
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 异常统一返回
     *
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(HttpServletRequest request, Exception e) {
        String requestInfo = String.format("====> ExceptionHandler ==>[RequestInfo:url=[%s],method=%s,ip%s,requestId=%s,requestArgs=%s],",
                request.getRequestURL(),
                request.getMethod(),
                IpAddressUtil.getRealIp(request),
                request.getAttribute(SystemConst.REQUEST_ID),
                request.getAttribute(SystemConst.REQUEST_ARGS));

        String exceptionInfo = "[Exception info:exception class:{},errorCode:{},message:{}]";
        String logStr = requestInfo + exceptionInfo;

        //传入参数异常
        if (e instanceof org.springframework.http.converter.HttpMessageNotReadableException) {
            log.warn(logStr, e.getClass().getName(), BizExceptionEnum.PARAMETER_ERROR.getCode(), e.getMessage());
            return Result.FAIL(BizExceptionEnum.PARAMETER_ERROR.getCode(), BizExceptionEnum.PARAMETER_ERROR.getMsg());
            //再写总的业务异常
        } else if (e instanceof BizException) {
            BizException ex = (BizException) e;
            log.warn(logStr, e.getClass().getName(), ex.getCode(), e.getMessage());
            return Result.FAIL(ex.getCode(), ex.getMessage());
        } else {
            log.error(logStr, e.getClass().getName(), SystemConst.SYS_EX_CODE, e);//长异常信息 e
            return Result.FAIL(SystemConst.SYS_EX_CODE, SystemConst.SYS_EX_MSG + ":" + e.getMessage());
        }
    }
}
