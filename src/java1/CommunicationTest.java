package java1;

/**
 * 两个线程交替打印
 *
 * sleep()和wait()的异同
 * 1.相同点：一旦执行方法，都可以使当前的线程进入阻塞状态
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *          2)调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须使用在同步代码中
 *          3）关于是否释放同步监视器。如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait会释放锁
 */
class Communicate implements Runnable{
    public int num=0;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (num <= 100) {
                    notify();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {

        Communicate c=new Communicate();
        Thread t1=new Thread(c);
        Thread t2=new Thread(c);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }

}
