package com.nio.http.demo.nettydemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;


// ByteToMessageDecoder is an implementation of ChannelInboundHandler
// which makes it easy to deal with the fragmentation issue.

// ByteToMessageDecoder calls the decode() method with an internally maintained cumulative buffer
// whenever new data is received
public class TimeDecoder extends ByteToMessageDecoder{
    @Override
    //  ByteToMessageDecoder will call decode() again when there is more data received.
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("TimeDecoder");
        // System.out.println(in.readableBytes());
        if (in.readableBytes() < 4) {
            return;
        }
        // decode() adds an object to out, it means the decoder decoded a message successfully.
        // out.add(in.readBytes(4));
        out.add(new UnixTime(in.readUnsignedInt()));
    }
}
