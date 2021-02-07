import java.util.concurrent.Callable;

public class MyCallableTask implements Callable{
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.print("线程ThreadResult返回结果");
        return "thread result";
    }
}

