package com.lyq.result;

import com.lyq.entity.Entity;
import com.lyq.enums.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Jack
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class Result extends Entity {

    private static final long serialVersionUID = 5591927021000190106L;

    // 是否成功
    protected Boolean success = true;

    // 状态码
    protected Integer code = 0;

    // 状态码描述
    protected String message = "";

    // 状态码参数
    protected String[] args;

//    // 返回数据
//    protected Map<String, Object> data = new HashMap<>();

    // 构造器私有
    private Result(){}

    // 通用返回成功
    public static Result success() {
        Result r = new Result();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    // 通用返回失败，未知错误
    public static Result error() {
        Result r = new Result();
        r.setSuccess(ResultCodeEnum.UNKNOWN_ERROR.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        r.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage());
        return r;
    }

    // 设置结果，形参为结果枚举
    public static Result setResult(ResultCodeEnum result) {
        Result r = new Result();
        r.setSuccess(result.getSuccess());
        r.setCode(result.getCode());
        r.setMessage(result.getMessage());
        return r;
    }

//    // 自定义返回数据
//    public Result data(Map<String,Object> map) {
//        this.setData(map);
//        return this;
//    }
//
//    // 通用设置data
//    public Result data(String key, Object value) {
//        this.data.put(key, value);
//        return this;
//    }

    // 自定义状态信息
    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    // 自定义状态码
    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    // 自定义返回结果
    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

}
