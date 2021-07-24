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
class Window extends Thread{
    private static int ticket=100;
//    private static Object obj=new Object();
    public void run() {
        while (true){
        synchronized(Window.class){
            if (ticket>0){
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName()+":卖票，票号为："+ticket);
                ticket--;
            }
            else {
                break;
            }

        }
    }
}
}
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");
        w1.start();
        w2.start();
        w3.start();
    }
}
