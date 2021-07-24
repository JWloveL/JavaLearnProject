package java2;

/**
 * @ProjectName: JavaSenior
 * @Package: java2
 * @ClassName: CollectionTest
 * @Author: 007
 * @Date: 2021/6/12 16:46
 * @Version: 1.8
 */
import org.junit.Test;

import java.util.*;

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
 * 向Collection接口的实现类的对象需重写equals方法
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
        System.out.println(coll.isEmpty());
    }

    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        //contains()
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new String("Tom")));

        //containsAll(Collection coll1)
        Collection coll1= Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }
    @Test
    public void test3(){
        //3.remove(Object obj)
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(343);
        coll.add(456);
        coll.add(45);

        System.out.println(coll.remove(123));

        //4.removeAll(Collection coll1):从当前集合中移除coll1中所有元素
        Collection coll1=Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);

        //retainAll(Collection coll1):交集：获取当前集合和coll1集合的交集，并返回给当前集合
        Collection coll2=Arrays.asList(343,456,213);
        coll.retainAll(coll2);
        System.out.println(coll);

        //6.equals(Object obj):要想返回true,需要当前集合和形参集合的元素都相同
        Collection coll3=Arrays.asList(343,456);
        System.out.println(coll.equals(coll3));
    }

    @Test
    public void test5(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);

        //集合-->数组：toArray()
        Object[] arr=coll.toArray();
        for(Object o: arr){
            System.out.println(o);
        }

        //数组-->集合
        List<String> l = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(l);
        System.out.println(l.size());//包装类size 3
        List arr1=Arrays.asList(new int[]{123,456});
        System.out.println(arr1);
        System.out.println(arr1.size());
        List arr2=Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2);
        System.out.println(arr2.size());


    }
}
