package Jobs;

/**
 * 多线程的创建，方式一，继承于thread类
 * 1.创建一个继承于thread类的子类
 * 2.重写thread类的run（）-->将此线程执行的操作声明在run方法中
 * 3.创建thread类的子类对象
 * 4。通过此对象调用start（）
 */
public class ThreadTest
{
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        //问题1：我们不能通过直接调用run（）的方式启动线程
        //问题2：不可以让已经start()的线程去执行，会报错，这时需要新建一个thread
        t2.start();

//        t1.run();
        //如下操作仍然是在main线程中
        for (int i=0;i<100;i++){
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++)
        {
            if(i%2==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
