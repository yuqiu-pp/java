package com.nio.http.demo.nettydemo;

import java.util.Date;

public class UnixTime {
    private final long value;

    public UnixTime() {
        // 调用 public UnixTime(long value) 构造函数
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value() - 2208988800L) * 1000L).toString();
    }
}
