package com.exm.myrpc.core.protocol;

import com.exm.myrpc.core.serializer.KryoSerializer;
import com.exm.myrpc.core.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
/**
 * 编码处理类
 */
public class RpcEncoder extends MessageToByteEncoder<Object>{

    private Serializer serializer = new KryoSerializer();

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {
        byte[] bytes = serializer.serialize(o);
        int lenth = bytes.length;
        byteBuf.writeInt(lenth);
        byteBuf.writeBytes(bytes);
    }
}
