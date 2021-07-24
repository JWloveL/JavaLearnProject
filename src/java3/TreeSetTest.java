package java3;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: TreeSetTest
 * @Author: 007
 * @Date: 2021/6/15 10:04
 * @Version: 1.8
 *
 * 自然排序：比較兩個對象是否相同的標準為：compareTo()返回0，不再是equals
 * 定制排序：比較兩個對象是否相同的標準為：compare()返回0，不再是equals
 * 内部采用紅黑樹，查詢速度比List快
 */
public class TreeSetTest {
    @Test
    public void test2(){
        TreeSet ts=new TreeSet();
//        ts.add(234);
//        ts.add("fddf"); TreeSet中必須添加相同類的對象

//        //舉例二：按對象大小順序排列
//        ts.add(123);
//        ts.add(12);
//        ts.add(113);
//        ts.add(33);
//        ts.add(11);
        ts.add(new Person(23,"Tom"));
        ts.add(new Person(21,"Tim"));
        ts.add(new Person(54,"Job"));
        ts.add(new Person(43,"Saul"));
        ts.add(new Person(15,"David"));
        ts.add(new Person(16,"David"));
        Iterator iterator=ts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test3(){

        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1=(Person) o1;
                    Person p2=(Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }
                else {
                    throw new RuntimeException("輸入類型不匹配");
                }
            }
        };
        TreeSet ts=new TreeSet(com);

        ts.add(new Person(23,"Tom"));
        ts.add(new Person(21,"Tim"));
        ts.add(new Person(54,"Job"));
        ts.add(new Person(16,"Saul"));
        ts.add(new Person(15,"David"));
        ts.add(new Person(16,"David"));

        Iterator iterator=ts.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
