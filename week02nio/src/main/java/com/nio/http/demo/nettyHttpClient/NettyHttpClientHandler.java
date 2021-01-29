package com.nio.http.demo.nettyHttpClient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NettyHttpClientHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("channelRead");
        System.out.println((String) msg);
        ctx.close();
    }
}
