package com.zyj.livestreamingdrainage.aop;

import com.zyj.livestreamingdrainage.exception.ClientException;
import com.zyj.livestreamingdrainage.tool.response.Response;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@Configuration
@ControllerAdvice
@ResponseBody
public class GlobalHandler {
    @ExceptionHandler(ClientException.class)
    public Response<?> batteryException(ClientException exception) {
        return Response.error(exception);
    }
}