package java12;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ProjectName: JavaSenior
 * @Package: java12
 * @ClassName: LambdaTest2
 * @Author: 007
 * @Date: 2021/6/23 21:23
 * @Version: 1.8
 *
 * 消费型接口 Consumer<T> void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function(T,R) R apply(T t)
 * 断定型接口 Predicate<T>  boolean test(T t)
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买了瓶矿泉水，花了"+aDouble);
            }
        });
        System.out.println("****************");

        //lambda表达式写法
        happyTime(599,money-> System.out.println("买了瓶矿泉水，花了"+money));

    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list= Arrays.asList("北京","南京","东京","西京","天津");
        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(list1);

        List<String> list2=filterString(list,s->s.contains("京"));
        System.out.println(list2);
    }

    public List<String > filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList=new ArrayList<>();

        for (String s: list){
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
