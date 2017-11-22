package com.exm.myrpc.core.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Kryo 一个快速高效的Java序列化框架，旨在提供快速，高效和易用的API。无论文件，数据库或网络数据Kryo都可以随时完成序列化
 */
public class KryoSerializer implements Serializer{
    @Override
    public byte[] serialize(Object obj) {
        Kryo kryo = new Kryo();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        kryo.writeClassAndObject(output,obj);
        output.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes) {
        Kryo kryo = new Kryo();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input input =  new Input(byteArrayInputStream);
        input.close();

        return (T) kryo.readClassAndObject(input);
    }
}
