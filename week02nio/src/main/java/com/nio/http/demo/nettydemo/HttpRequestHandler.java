package com.nio.http.demo.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpRequestHandler extends MessageToByteEncoder<FullHttpRequest>{
    @Override
    protected void encode(ChannelHandlerContext ctx, FullHttpRequest msg, ByteBuf out) throws Exception {
        System.out.println(msg.getUri());
    }
}
