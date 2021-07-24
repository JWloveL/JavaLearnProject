package java2;
/**
        *@ProjectName:JavaSenior
        *@Package:java2
        *@ClassName:CollectionTest
        *@Author:007
        *@Description:
        *@Date:2021/6/12 16:07
        *@Version:1.8
        */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * 集合框架
 * |---Collection接口：单列集合，用来存储一个一个的对象
 *      |---List接口：存储有序的，可重复的数据
 *          |---ArrayList,LinkedList,Vector
 *      |---Set接口：存储无序的，不可重复的数据
 *          |---HashSet,LinkedHashSet,TreeSet
 * |---Map接口：双列集合，用来存储一对（key -value)一对数据
 *      |---HashMap,LinkedHashMap,TreeMap,HashTable,Properties
 *
 * Collection接口中方法的使用
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();

        coll.add("AA");
        coll.add("BB");
        coll.add(123);
        coll.add(new Date());

        System.out.println(coll.size());

        //addAll()
        Collection coll1=new ArrayList();
        coll1.add(234);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
    }

}
