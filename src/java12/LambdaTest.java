package java12;

import org.junit.Test;

import java.util.Comparator;

/**
 * @ProjectName: JavaSenior
 * @Package: java12
 * @ClassName: LambdaTest
 * @Author: 007
 * @Date: 2021/6/23 15:34
 * @Version: 1.8
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("hhhhh");
            }
        };
        r1.run();

        Runnable r2=()-> System.out.println("gggggg");
        r2.run();

    }
    @Test
    public void test2(){
        Comparator<Integer> com1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com1.compare(34, 23));
//Lambda表达式写法
        Comparator<Integer> com2=(o1,o2)->Integer.compare(o1,o2);
        System.out.println(com2.compare(23, 24));
        //方法引用
        Comparator<Integer> com3=Integer::compare;
        System.out.println(com3.compare(342, 2231));
    }
}
