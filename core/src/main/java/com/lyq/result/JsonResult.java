package com.lyq.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult {

    // 是否成功
    private Boolean success;

    // 状态码
    private String code;

    // 状态码描述
    private String message;

    // 返回的数据
    private Object data;

}
