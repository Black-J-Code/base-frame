package com.lyq.exception;

import com.lyq.enums.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.lyq.result.Result;

/**
 * @Author Jack
 * 自定义异常
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class BaseException extends RuntimeException {

    protected Integer errorCode;

    protected String[] args;

    public BaseException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.errorCode = resultCodeEnum.getCode();
    }

    public BaseException(Result result){
        super(result.getMessage());
        this.errorCode = result.getCode();
        this.args = result.getArgs();
    }

    @Override
    public String toString() {
        return "BaseException{" + "code=" + errorCode + ", message=" + this.getMessage() + '}';
    }

}
