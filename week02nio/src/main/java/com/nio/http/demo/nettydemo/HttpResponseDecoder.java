package com.nio.http.demo.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.List;

public class HttpResponseDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("HttpResponseDecoder");

        // FullHttpRequest fullRequest =

        String str = "";
        if (in.readableBytes() > 0) {
            byte[] bytes = new byte[in.readableBytes()];
            in.getBytes(in.readerIndex(), bytes);
            str = new String(bytes, 0, in.readableBytes());
            // System.out.println(str);
        } else {
            return;
        }
        out.add(str);
    }
}
