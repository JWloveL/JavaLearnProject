package Jobs;

/**
 * 创建三个窗口卖票，总票数为100张
 * 存在线程安全问题：待解决
 * 1.问题：存在重票，错票
 * 法一：synchronized(同步监视器){}
 * 所有窗口必须共享一个锁
 * 补充：在实现Runnable接口方式中，可以将this充当同步监视器，考虑使用当前类充当同步监视器
 * 需要被同步的代码不能多也不能少
 * 法二：同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中，我们不妨把此
 */
class Window4 extends Thread{
    private static int ticket=100;
//    private static Object obj=new Object();
    public void run() {
        while (true){
            show();
    }
}
    public static synchronized void show(){
        if (ticket>0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
            ticket--;
        }
    }

}

public class WindowTest3 {
    public static void main(String[] args) {
        Window4 w1 = new Window4();
        Window4 w2 = new Window4();
        Window4 w3 = new Window4();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
