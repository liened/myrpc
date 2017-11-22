package com.exm.myrpc.core.serializer;

/**
 * 序列化类
 */
public interface Serializer {

    byte[] serialize(Object obj);
    <T> T deserialize(byte[] bytes);
}
