package ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


// 1.定义处理器类
public class JdkProxy implements InvocationHandler{

    // 被代理对象
    private Object target;
    // 依赖注入方式：通过传入类实例来初始化成员变量
    public JdkProxy(Object target){
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
        // 创建代理类对象实例 需要传入接口信息
        Object proxy = (Hello) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
        return proxy;
    }


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        // 创建被代理对象
        HelloImpl hello = new HelloImpl();
        // 2.包装被代理对象
        JdkProxy jdkProxy = new JdkProxy(hello);

        /**
         * 可以将这部分封装到DynamicProxy类中，通过getProxy返回代理对象
         * 创建代理对象时，将处理器类实例和被代理接口关联了起来
         */
        // [方法1] 3.创建代理对象. 不强转看不到say接口
        // JDK的Proxy类
        Hello proxyNew = (Hello) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                hello.getClass().getInterfaces(),
                jdkProxy);

        //
        proxyNew.sayHello("proxy");

        // ------------------------------------------------------


        // [方法2]  3. 封装 [方法2]
        Hello proxyGet = (Hello) jdkProxy.getProxy();

        // 调用接口
        proxyGet.sayHello("proxy");
    }
}
