package java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一，说明：Java中的对象，正常情况下，只能进行比较：== 或 ！=。不能使用>或<的
 * 但是在开发场景中，我们需要对多个对象进行排序
 *
 * 二. Comparable接口与Comparator接口使用的对比
 *  Comparable接口的方式一旦一定，保证Comparable在任何位置都可以比较大小
 *  Comparator属于临时性的比较
 *
 *
 */
public class CompareTest {
    /*
    Comparable接口的使用举例
    1.像String,包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方法
    2.对于自定义类来说，如果需要排序，就需要实现Comparable接口,重写compareTo()方法
     */
    @Test
    public void test1(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ"};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        Goods[] arr=new Goods[4];
        arr[0]=new Goods("Apple",54);
        arr[1]=new Goods("XiaoMi",24);
        arr[2]=new Goods("SamSung",42);
        arr[3]=new Goods("HuaWei",24);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test3(){
        String[] arr=new String[]{"AA","CC","KK","MM","GG","JJ"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
