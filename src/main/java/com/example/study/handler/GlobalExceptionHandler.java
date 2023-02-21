package com.example.study.handler;

import com.example.study.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result exceptionHandler(Exception e){
        log.error("系统异常",e);
        return Result.error(500,e.getMessage());
    }
}
