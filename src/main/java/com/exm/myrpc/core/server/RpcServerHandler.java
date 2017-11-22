package com.exm.myrpc.core.server;

import com.exm.myrpc.core.protocol.Request;
import com.exm.myrpc.core.protocol.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 服务端对客户端过程方法请求的处理逻辑
 * 此处的服务代码里已经解释过，就是服务端所注册的接口（其实也不一定是接口，对外可能是restful的一个地址）的实现类
 */
public class RpcServerHandler extends SimpleChannelInboundHandler<Request> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RpcServerHandler.class);

    private Object service;
    //此处传入service的实现对象
    public RpcServerHandler(Object service){
        this.service = service;
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext,Request msg) throws Exception{
        String methodName = msg.getMethod();
        Object[] params = msg.getParams();
        Class<?>[] parameterTypes = msg.getParameterTypes();
        long requestId = msg.getRequestId();
        //通过反射来获取客户端所需要的方法并执行
        Method method = service.getClass().getDeclaredMethod(methodName,parameterTypes);
        method.setAccessible(true);
        Object invoke = method.invoke(service,params);
        Response response = new Response();
        response.setRequestId(requestId);
        response.setResponse(invoke);
        channelHandlerContext.pipeline().writeAndFlush(response);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        LOGGER.error("Exception caugth on {}, ",ctx.channel(),cause);
        ctx.channel().close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Request request) throws Exception {

    }
}
