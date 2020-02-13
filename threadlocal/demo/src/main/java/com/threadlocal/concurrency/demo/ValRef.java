package com.threadlocal.concurrency.demo;


public class ValRef<T> {
    private T v;

    public void set(T v){
        this.v = v;
    }

    public T get(){
        return v;
    }

}
