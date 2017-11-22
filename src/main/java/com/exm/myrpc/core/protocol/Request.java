package com.exm.myrpc.core.protocol;

import lombok.Data;

/**
 * 通用模块 -请求类
 */
@Data
public class Request {
    private long requestId;
    private Class<?> clazz;
    private String method;
    private Class<?>[] parameterTypes;
    private Object[] params;
    private long requestTime;

}
