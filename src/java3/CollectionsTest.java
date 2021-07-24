package java3;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: CollectionsTest
 * @Author: 007
 * @Date: 2021/6/16 10:44
 * @Version: 1.8
 *
 * Collections是一個操作數據的工具類
 *
 */
public class CollectionsTest {
    @Test
    public void test1(){
        List list=new ArrayList<>();
        list.add(123);
        list.add(54);
        list.add(1523);
        list.add(154);
        list.add(12);
        list.add(12);

        System.out.println(list);

        //反轉
        Collections.reverse(list);
        System.out.println(list);
        //隨機排序
        Collections.shuffle(list);
        System.out.println(list);
        //排序
        Collections.sort(list);
        System.out.println(list);
        //計算元素在集合中出現的次數
        int num=Collections.frequency(list,12);
        System.out.println(num);
        //複製集合
        List dest= Arrays.asList(new Object[list.size()]);
        System.out.println(dest);
        Collections.copy(dest,list);
        System.out.println(dest);

    }
}
