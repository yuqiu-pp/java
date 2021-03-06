package com.nio.http.demo.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // ((ByteBuf) msg).release();
        ByteBuf in = (ByteBuf) msg;
        // try {
        //     while (in.isReadable()) {
        //         // System.out.println((char) in.readByte());
                // System.out.println();
        //     }
        // } finally {
        //     ReferenceCountUtil.release(msg);
        // }
        ctx.write(msg);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
