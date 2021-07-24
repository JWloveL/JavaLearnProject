package java4;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: JavaSenior
 * @Package: java4
 * @ClassName: Order
 * @Author: 007
 * @Date: 2021/6/16 16:03
 * @Version: 1.8
 */
public class Order <T>{
    String orderName;
    int orderId;

    T orderT;

    public Order(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public Order() {
    }

    public T getOrderT(){
        return orderT;
    }

    public void setOrderT(T orderT){
        this.orderT=orderT;
    }
    //静态方法不能使用类的泛型
//    public static void show( T orderT){
//        System.out.println(orderT);
//    }

    //泛型方法,其所在的类是不是泛型类都没有关系
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非实例化类时确定
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> arrayList=new ArrayList<>();
        for(E e : arr){
            arrayList.add(e);
        }
        return arrayList;
    }
}
