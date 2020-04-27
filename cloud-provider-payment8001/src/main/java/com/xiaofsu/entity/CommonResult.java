package com.xiaofsu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author xiaoFsu
 * @Date 2020/4/27 18:07
 * @Version 1.0
 */
@Data
//全参数
@AllArgsConstructor
//空参数
@NoArgsConstructor
@ToString
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
