package Jobs;

/**
 * 测试Thread中的常用方法：
 * 1.start()：启动当前线程：调用当前线程的run()
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回执行当前代码的线程
 * 4.getName():获取当前线程的名字
 * 5.setName():设置当前线程的名字
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态
 * 8.stop():已过时
 * 9.sleep(long millitime):让当前线程“睡眠”指定的milltime毫秒
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIOTITY:5
 * 2.如何获取设置当前线程的优先级
 *  getPriority():获取线程的优先级
 *  setPriority(int p):设置线程的优先级
 *  说明：高优先级的线程要抢占低优先级线程cpu的执行权。但是只是从概率上讲
 */
public class ThreadMethodTest {
    public static void main(String[] args){
        HelloThread t1 = new HelloThread();
//        HelloThread t2 = new HelloThread();
        Thread.currentThread().setName("主线程");
        t1.setName("线程一");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        for (int i = 0; i < 100; i++) {
            if(i%2==1)
                System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority()+":"+i);
//            if(i%20==15) {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0) {
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" +Thread.currentThread().getPriority()+":"+ i);
            }
        }
    }
}
