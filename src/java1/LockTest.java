package java1;

import java.util.concurrent.locks.ReentrantLock;

class Window implements Runnable{
    private int ticket=100;
    private ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {

        while (true){
            try{
                lock.lock();
            if (ticket>0){
                try {
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                ticket--;
            }
            else {
                break;
            }
        }finally {
                lock.unlock();
            }
        }

    }
}
public class LockTest {
    public static void main(String[] args) {
        Window w=new Window();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }


}
