package Jobs;

class Window1 implements Runnable{

    private static int ticket=100;
//    Object obj=new Object();
    public void run() {
        synchronized(this){//此时this是唯一的
            while (true){
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
            }
        }
    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w=new Window1();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }


}
