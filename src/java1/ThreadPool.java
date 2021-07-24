package java1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Mthread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
        //管理线程池
//        service1.setKeepAliveTime();
        //2.执行指定的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new Mthread());//适用于Runnable
        //3.关闭线程池
        service.shutdown();
    }
}
