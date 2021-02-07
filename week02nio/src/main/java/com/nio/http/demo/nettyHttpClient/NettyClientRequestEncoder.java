package com.nio.http.demo.nettyHttpClient;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.http.HttpRequest;

public class NettyClientRequestEncoder extends MessageToByteEncoder<HttpRequest>{
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, ByteBuf byteBuf) throws Exception {
        System.out.println("request encoder");
    }
}
