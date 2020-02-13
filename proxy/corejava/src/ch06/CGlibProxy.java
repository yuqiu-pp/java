package ch06;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


// 1.处理器
public class CGlibProxy implements MethodInterceptor{
    // 单例
    private static CGlibProxy proxyInstance = new CGlibProxy();
    // 构造函数不能被外部调用
    private CGlibProxy(){}
    // 返回单例
    public static CGlibProxy getCGlibProxy(){
        return proxyInstance;
    }


    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    // 不需要保存被被代理对象，因为作为参数传入了
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        before();
        // method没有用，仅仅是传入了方法的参数objects
        Object rst = methodProxy.invokeSuper(o, objects);
        after();

        return rst;
    }


    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }


    public static void main(String[] args) {
        CGlibProxy glibProxy = CGlibProxy.getCGlibProxy();
        Good proxy = glibProxy.getProxy(Good.class);
        proxy.go("CGlib");
    }

}
