package java1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class BankTest
{

}
class Bank{
    private Bank(){}
    private static Bank instance=null;
    private  static synchronized Bank getInstance(){
        if (instance==null){
            instance=new Bank();
        }
        return instance;
    }

}
