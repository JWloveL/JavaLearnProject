package java4;

import org.junit.Test;

import java.util.List;

/**
 * @ProjectName: JavaSenior
 * @Package: java4
 * @ClassName: GenericTest1
 * @Author: 007
 * @Date: 2021/6/16 16:09
 * @Version: 1.8
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定義了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型，建议在实例化时要指明类的泛型
        Order<Object> order = new Order<>();
        order.setOrderT(123);
        order.setOrderT("ABC");
        //建议：实例化时指明类的泛型
        Order<String> stringOrder = new Order<>();
    }
    //测试泛型方法
    @Test
    public void test2(){
        Order<String> order=new Order<>();
        Integer[] arr=new Integer[]{1,2,3,4};
        List<Integer> list=order.copyFromArrayToList(arr);
        System.out.println(list);
    }

}
