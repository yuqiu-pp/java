public class HelloLocal {

    private static ThreadLocal<Long> x = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            System.out.println("threadlocal initialValue ...");
            return 1L;
        }
    };

    private static long count;

    public long add(){
        count += 1;
        return count;
    }


    public static void main(String[] args) {
        // x没有初值，get会触发initialValue的调用
        // System.out.println(x.get());

        x.set(233L);
        // x已设置值，initialValue不再调用
        System.out.println(x.get());

        // x.remove();
        // x值被移除，调用get会触发initialValue的调用
        // System.out.println(x.get());


        System.out.println("new thread ");

        // new Thread(){
        //     @Override
        //     public void run() {
        //         System.out.println(x.get());
        //     }
        // }.start();

        // lambda表达式实现了runnable
        new Thread(() -> System.out.println(x.get())).start();

    }

}
