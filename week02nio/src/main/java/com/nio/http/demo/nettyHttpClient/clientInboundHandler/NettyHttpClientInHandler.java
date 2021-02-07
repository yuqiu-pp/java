package com.nio.http.demo.nettyHttpClient.clientInboundHandler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;

public class NettyHttpClientInHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("InHandler  channelRead");
        // System.out.println((String) msg);
        if (msg instanceof HttpResponse) {
            HttpResponse response = (HttpResponse) msg;
            System.out.println("CONTENT_TYPE:" + response.headers().get(HttpHeaders.Names.CONTENT_TYPE));
        }
        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            ByteBuf buf = content.content();
            String cont = buf.toString(io.netty.util.CharsetUtil.UTF_8);
            System.out.println(cont);
            ctx.channel().writeAndFlush(cont);
            buf.release();
        }
        // ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("InHandler channelActive");

        super.channelActive(ctx);
    }
}
