import java.util.concurrent.*;

import static java.util.concurrent.ThreadPoolExecutor.*;

public class Main {

    public static void main(String[] args) {
        // 1. futureTask
        // 创建task
        MyCallableTask task01 = new MyCallableTask();
        FutureTask<String> futureTask = new FutureTask<String>(task01);
        // 运行task
        new Thread(futureTask).start();
        try {
            System.out.println("--- " + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 2. future + executorService
        ExecutorService executorService = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                1,
                TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(100),
                new CustomerThreadFactory(), // 可以省略
                new AbortPolicy()
        );
        Future future = executorService.submit(task01);
        executorService.shutdown();
        try {
            System.out.println("--- " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 3. future + threadPool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        future = fixedThreadPool.submit(task01);
        fixedThreadPool.shutdown();
        try {
            System.out.println("--- " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        //
    }


}
