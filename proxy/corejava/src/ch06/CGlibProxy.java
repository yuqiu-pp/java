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


    // 创建代理类对象实例 这里不需要传入接口信息
    // TODO 因为cglib动态代理采取的是创建目标类的子类的方式
    public <T> T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls, this);
    }

    // 相对于JDK的Proxy，不需要保存被被代理对象，因为作为参数传入了
    /**
     *
     * @param o             被代理对象
     * @param method
     * @param objects       方法的参数
     * @param methodProxy   方法级别的代理，？方法拦截器
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        before();
        // 仅仅是传入了方法的参数objects
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
        /**
         * 代理需要3部分内容：
         * 代理的处理器类：添加了拦截后要做的操作
         * 代理类实例：创建实例时，把处理器类和被代理对象关联到它自己。
         *           这样它调用被代理类的方法就可以被代理方法的参数传递给拦截方法
         */
        CGlibProxy glibProxy = CGlibProxy.getCGlibProxy();
        Good proxy = glibProxy.getProxy(Good.class);
        proxy.go("CGlib");
    }

}
