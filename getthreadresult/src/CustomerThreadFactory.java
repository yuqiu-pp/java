import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomerThreadFactory implements ThreadFactory{
    private AtomicInteger serial = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("customer thread - " + serial.getAndIncrement());
        // 不设置为 守护线程，main线程不能结束
        thread.setDaemon(true);
        return thread;
    }
}
