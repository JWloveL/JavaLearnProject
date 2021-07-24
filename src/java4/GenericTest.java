package java4;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java4
 * @ClassName: GenericTest
 * @Author: 007
 * @Date: 2021/6/16 15:20
 * @Version: 1.8
 *
 * //泛型不同的引用不能相互赋值
 *
 * //异常类不能是泛型的
 *
 */
public class GenericTest {
    @Test
    public void test1(){
        ArrayList<Integer> list=new ArrayList<Integer>();

        list.add(78);
        list.add(72);
        list.add(54);
        list.add(75);
//        編譯時，就會進行類型檢查，保證數據的安全
//        list.add("df");
        //方式一
//        for (Integer score: list){
//            int stuScore = score;
//            System.out.println(stuScore);
//        }
        //方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("David",18);
        map.put("Saul",65);
        map.put("Samuel",78);

        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String name=e.getKey();
            int age=e.getValue();
            System.out.println("name:"+name+" age:"+age);
        }
    }

 //1.泛型在继承方面的体现
    //类A是类B的父类，G<A> 和 G<B> 两者不具备子父类关系，两者是并列关系,而A<G> 和 B<G> 可以
    @Test
    public void test3(){
        Object obj=null;
        String str=null;
        obj=str;

        List<Object> list1=null;
        List<String> list2=null;
        //此时的list1和list2的类型不具有子父类关系
//        list1=list2;
    }

    @Test
    public void test4(){
        AbstractList<String> list1=null;
        List<String> list2=null;
        ArrayList<String> list3=null;

        list1=list3;
        list2=list3;

    }
    // 2.通配符的使用,通配符：?
    //类A是类B的父类，G<A> 和 G<B> 两者不具备子父类关系,二者公共父类 G<?>
    @Test
    public void test5(){
        List<Object> list1=null;
        List<String> list2=null;

        List<?> list=null;
        list=list1;
        list=list2;

        //
        List<String> list3=new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list=list3;
        //添加：对于List<?>就不能向其内部添加数据，除了添加null以外
//        list.add("DD");
        list.add(null);

        //获取(读取)，允许读取数据
        Object o=list.get(0);

    }

    public void print(List<?> list){
        Iterator<?> iterator=list.iterator();
        while (iterator.hasNext())
        {
            Object obj=iterator.next();
            System.out.println(obj);
        }
    }
}
