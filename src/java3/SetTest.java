package java3;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: SetTest
 * @Author: 007
 * @Date: 2021/6/14 10:21
 * @Version: 1.8
 *
 * 1.Set接口的框架
 *
 * |--Collection接口:單列集合，用來存儲一個一個的對象
 *  |--Set接口：存儲無序的，不可重複的數據
 *   |--HashSet作爲set接口的主要實現類，綫程不安全的，可以存儲null
 *   |--TreeSet:可以按照添加對象的指定屬性，進行排序
 *   HashSet底層:數組加鏈表的結構(jdk 7)
 *   LinkedHashSet:記錄了數據的前後順序,維護了兩個引用
 *   無序性不等於隨機性
 */
public class SetTest {
    @Test
    public void test1(){
        HashSet<Object> s = new HashSet<>();
        s.add(456);
        s.add(324);
        s.add(231);
        s.add("ff");
        s.add(324);
        s.add(new Person(23,"Tom"));
        s.add(new Person(23,"Tom"));
        for(Object o: s){
            System.out.println(o);
        }
    }
    @Test
    public void test2(){
        HashSet<Object> s = new LinkedHashSet<>();
        s.add(456);
        s.add(324);
        s.add(231);
        s.add("ff");
        s.add(324);
        s.add(new Person(23,"Tom"));
        s.add(new Person(23,"Tom"));
        for(Object o: s){
            System.out.println(o);
        }
    }
}
