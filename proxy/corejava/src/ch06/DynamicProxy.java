package ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


// 1.定义处理器
public class DynamicProxy implements InvocationHandler{

    // 被代理对象
    private Object target;

    public DynamicProxy(Object target){
        this.target = target;
    }

    // 处理器类
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(target, args);
        after();

        return obj;
    }

    public void before(){
        System.out.println("before");
    }

    public void after(){
        System.out.println("after");
    }

    public Object getProxy(){
        Object proxy = (Hello) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        return proxy;
    }


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // 2.包装被代理对象
        HelloImpl hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        /**
         * 可以将这部分封装到DynamicProxy类中，通过getProxy返回代理对象
         */
        // 3.创建代理对象. 不强转看不到say接口 [方法1]
        // Hello proxy = (Hello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
        //         hello.getClass().getInterfaces(),
        //         dynamicProxy);

        // 3 封装 [方法2]
        Hello proxy = (Hello) dynamicProxy.getProxy();

        // 调用接口
        proxy.sayHello("proxy");
    }
}
