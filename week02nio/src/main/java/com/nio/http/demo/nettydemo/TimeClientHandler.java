package com.nio.http.demo.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter{
    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("handlerAdded");
        buf = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("handlerRemoved");
        buf.release();
        buf = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("channelRead");
        // ByteBuf m = (ByteBuf) msg;
        // buf.writeBytes(m);
        // m.release();
        // System.out.println(buf.readableBytes());
        // System.out.println(buf.readChar());


        // POJO
        // UnixTime m = (UnixTime) msg;
        System.out.println(msg);
        ctx.close();

        // 移到 TimeDecorder 处理了
        // if (buf.readableBytes() >= 4) {
        //     long currentTimeMills = (buf.readUnsignedInt() - 2208988800L) * 1000L;
        //     System.out.println(new Date(currentTimeMills));
        //     ctx.close();
        // }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
