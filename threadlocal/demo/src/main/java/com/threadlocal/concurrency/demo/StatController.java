package com.threadlocal.concurrency.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class StatController {

    // private static Integer c=0;
    // 性能会很低
    // synchronized void _add() throws InterruptedException {
    //     Thread.sleep(100);
    //     c++;
    // }


    // 每个线程有各自的threadlocal，保存各自的数据，所以要把它们值和起来才是最终结果
    static ThreadLocal<Integer> c = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    static ThreadLocal<Integer> cc = ThreadLocal.withInitial(() -> 0);


    @RequestMapping("/stat")
    public Integer stat(){
        return c.get();
    }

    @RequestMapping("/add")
    public void add() throws InterruptedException {
        _add();
    }


    private Integer _add() throws InterruptedException {
        c.set(c.get()+1);
        System.out.println(c.get());
        return 1;
    }


    /**
     *  把每个线程threadlocal的值都合起来
     *
     * 1.用一个Map<thread, 值的引用>
     * 2.其实只要一个Set<值的引用>就可以，因为我们只关系最终结果
     *
     * 实现值引用的方式：建立类 class ValRef<T> ，只需要get、set方法
     * 作用：让值即存在于threadlocal，也存在于map中
     *
     */
    private Set<ValRef<Integer>> set = new HashSet<>();

    // private ThreadLocal<ValRef<Integer>> x = new ThreadLocal<ValRef<Integer>>(){
    //     @Override
    //     // 这块代码的线程安全需要考虑清楚
    //     protected ValRef<Integer> initialValue() {
    //         ValRef<Integer> v = new ValRef<>();  // 线程自己创建的 局部变量，安全
    //         v.set(0);       // 线程自己创建的变量赋值，安全
    //
    //         // set.add(v);      // 所有线程共享的set，所以代码是临界区
    //         add(v);             // 用线程安全函数代替
    //         System.out.println("initial...");
    //         return v;
    //     }
    // };

    private ThreadLocal<ValRef<Integer>> xx = ThreadLocal.withInitial(() -> {
        ValRef<Integer> v = new ValRef<>();  // 线程自己创建的 局部变量，安全
            v.set(0);       // 线程自己创建的变量赋值，安全

            // set.add(v);      // 所有线程共享的set，所以代码是临界区
            add(v);             // 用线程安全函数代替
            System.out.println("initial...");
            return v;
    });

    synchronized private void add(ValRef<Integer> v){
        set.add(v);
    }

    @RequestMapping("/stat2")
    public Integer stat2(){
        // 局部变量，线程安全
        Integer num = 0;

        for (ValRef<Integer> s: set){
            num += s.get();
        }
        System.out.println(num);
        return num;
    }

    @RequestMapping("/stat3")
    public Integer stat3(){
            return set.stream().map(x -> x.get()).reduce((a, n)-> a+=n).get();
    }

    @RequestMapping("/add2")
    public void add2(){
        // ValRef<Integer>  v = x.get();
        // Integer i = v.get() + 1;
        // v.set(i);
        // x.set(v); // 是否有必要做这步。  引用类型，所以不需要做

        ValRef<Integer> vv = xx.get();
        vv.set(vv.get()+1);
    }

}
