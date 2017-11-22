package com.exm.myrpc.core.protocol;

import com.exm.myrpc.core.serializer.KryoSerializer;
import com.exm.myrpc.core.serializer.Serializer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * Created by Administrator on 2017-11-22.
 */
public class RpcDecoder extends LengthFieldBasedFrameDecoder{

    private Serializer serializer = new KryoSerializer();

    public RpcDecoder(int maxFrameLength) {
        super(maxFrameLength, 0, 4,0,4);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        ByteBuf decode = (ByteBuf) super.decode(ctx,in);
        if (decode != null){
            int byteLength = decode.readableBytes();
            byte[] byteHolder = new byte[byteLength];
            decode.readBytes(byteHolder);
            Object deserialize = serializer.deserialize(byteHolder);
            return deserialize;
        }
        System.err.println("Decoder Result is null");
        return null;
    }
}
