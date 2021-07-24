package java12;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ProjectName: JavaSenior
 * @Package: java12
 * @ClassName: LambdaTest1
 * @Author: 007
 * @Date: 2021/6/23 15:59
 * @Version: 1.8
 *
 * 总结：
 * ->左边：Lambda形参列表的参数类型可以省略
 * ->右边：Lambda体应该使用一对{}包裹：如果lambda体只有一条执行语句（可能是return语句），可以省略{}
 */
public class LambdaTest1 {
    @Test
    //格式一：无参，无返回值
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("hhhhh");
            }
        };
        r1.run();

        Runnable r2=()-> System.out.println("ggggg");
        r2.run();

        Runnable r3=()-> System.out.println("sdfdf");
    }
    //格式二：Lambda需要一个参数，但无返回值
    @Test
    public void test2(){
        Consumer<String> con=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hhhhh");

        Consumer<String> con1=(String s)-> System.out.println(s);
        con1.accept("sdffd");

    }
    @Test
    //格式三：类型推断，数据类型可以省略，因为可有编译器推断得出
    public void test3(){
        Consumer<String> con=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hhhhh");

        Consumer<String> con1=s-> System.out.println(s);
        con1.accept("fdsfg");

    }

    @Test
    //格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    public void test6(){
        Comparator<Integer> com1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println("******************");
        Comparator<Integer> com2=(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

    }
    @Test
    public void test7(){
        Comparator<Integer> com1=(o1, o2) ->{
          return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 4));

        Comparator<Integer> com2=(o1,o2)->o1.compareTo(o2);

        System.out.println(com2.compare(23, 231));

    }
}
