package com.exm.myrpc.core.protocol;

import lombok.Data;

/**
 * 通用模块 -响应类
 */
@Data
public class Response {
    private long requestId;
    private Object response;
    private Throwable throwable;

}
