package ch06;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

    public static void main(String[] args) {

        final int MAX_NUM = 1000;
        Object[] elements = new Object[MAX_NUM];


        for (int i = 0; i < MAX_NUM; i++) {
            Integer value = i + 1;
            // 2.代理类 包装 被代理类
            TraceHandler handler = new TraceHandler(value);
            // 3.动态创建 接口 代理类，即代理类要调用那些接口
            elements[i] = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);

        }

        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements, key);
        if (result > 0){
            System.out.println(result);
        }

    }


    // 1.定义代理类
    public static class TraceHandler implements InvocationHandler{

        // 保存被代理的类
        private Object target;

        public TraceHandler(Object target){
            this.target = target;
        }

        // 要做的事情：新增的事情 + 被代理对象要做的事情
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.print(target + "." + method.getName() + "(");
            if (args != null){
                for (int i = 0; i < args.length; i++) {
                    System.out.print(args[i]);
                    if (i < args.length-1){
                        System.out.println(",");
                    }
                }
            }

            System.out.println(")");
            System.out.print("before...");
            Object obj = method.invoke(target, args);
            System.out.println("after");

            return obj;
        }
    }
}
