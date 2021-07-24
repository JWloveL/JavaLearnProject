package java1;

class Account{
    public int check;
    public Account(int c){
        this.check=c;
    }
    //存钱
    public synchronized void deposit(double amt){
        if(amt>0){
            check+=amt;
        }

        System.out.println(Thread.currentThread().getName()+"存钱成功，余额为："+check);
    }
}
class Customer extends Thread{
    private Account acc;
    public Customer(Account acc){
        this.acc=acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {

        Account a=new Account(0);
        Customer c1=new Customer(a);
        Customer c2=new Customer(a);
        c1.setName("甲");
        c2.setName("乙");
        c1.start();
        c2.start();
    }
}
