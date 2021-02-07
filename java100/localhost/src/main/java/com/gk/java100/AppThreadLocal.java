package com.gk.java100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */

@EnableAutoConfiguration
@RestController
public class AppThreadLocal
{

    private ThreadLocal<Integer> currentLocal = ThreadLocal.withInitial(()-> null);

    // @RequestMapping("/wrong")
    // @ResponseBody

    @GetMapping("wrong")
    public Map<String, String> wrong(@RequestParam("userId") Integer userId){
        String before = Thread.currentThread().getName() + ":" + currentLocal.get();
        currentLocal.set(userId);
        String after = Thread.currentThread().getName() + ":" + currentLocal.get();

        Map<String, String> result = new HashMap();
        result.put("before", before);
        result.put("after", after);
        return result;
    }


    public static void main( String[] args )
    {
        System.out.println( "Hello threadlocal" );
        SpringApplication.run(AppThreadLocal.class);
    }
}
