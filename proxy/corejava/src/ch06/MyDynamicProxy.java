package ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK实现的动态代理
 * 与JdkProxy一样，只是所有类都写到一个java文件中了
 */
public class MyDynamicProxy {

    public static  void main (String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        // 创建代理对象实例
        Hello proxyHello = (Hello) Proxy.newProxyInstance(
                HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(),
                handler);
        // 调用被代理的方法
        proxyHello.sayHello("Dynamic Proxy");
    }
}


interface Hello {
    void sayHello(String name);
}


class HelloImpl implements Hello {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello" + name);
    }
}


class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(target, args);
        return result;
    }
}
