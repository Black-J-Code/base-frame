package com.lyq.handler;

import com.lyq.enums.ResultCodeEnum;
import com.lyq.exception.BaseException;
import com.lyq.result.Result;
import com.lyq.utils.ExceptionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Jack
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**-------- 通用异常处理方法 --------**/
    @ResponseBody
    @ExceptionHandler
    public Result error(Exception e) {
        log.error(ExceptionUtils.getMessage(e));
        return Result.error();
    }

    /**-------- 指定异常处理方法 --------**/
    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public Result error(NullPointerException e) {
        log.error(ExceptionUtils.getMessage(e));
        return Result.setResult(ResultCodeEnum.NULL_POINTER);
    }

    /**-------- 自定义定异常处理方法 --------**/
    @ResponseBody
    @ExceptionHandler(BaseException.class)
    public Result error(BaseException e) {
        log.error(ExceptionUtils.getMessage(e));
        return Result.error().message(e.getMessage()).code(e.getErrorCode());
    }

}
