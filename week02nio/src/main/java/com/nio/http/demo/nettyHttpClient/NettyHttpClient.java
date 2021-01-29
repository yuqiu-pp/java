package com.nio.http.demo.nettyHttpClient;

import com.nio.http.demo.nettydemo.HttpResponseDecoder;
import com.nio.http.demo.nettydemo.TimeClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.URI;


public class NettyHttpClient {
    private int port;
    private String url;

    private static final EventLoopGroup workerGroup = new NioEventLoopGroup();
    //启动类
    private static final Bootstrap b = new Bootstrap();

    public NettyHttpClient(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public void start() throws InterruptedException {
        try {
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new NettyHttpClientInitializer());

            // host
            ChannelFuture f = b.connect(url, port).sync();

            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }

    public String getRequest(String url) {
        return null;
    }

    public static void main(String[] args) throws InterruptedException {
        NettyHttpClient client = new NettyHttpClient("localhost", 8801);
        client.start();
    }
}
