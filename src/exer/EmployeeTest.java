package exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @ProjectName: JavaSenior
 * @Package: exer
 * @ClassName: EmployeeTest
 * @Author: 007
 * @Date: 2021/6/15 15:20
 * @Version: 1.8
 */
public class EmployeeTest {
    @Test
    public void test1(){
        TreeSet set=new TreeSet();

        Employee e1=new Employee("liudehua",55,new MyDate(1966,11,7));
        Employee e2=new Employee("guofucheng",45,new MyDate(1976,5,4));
        Employee e3=new Employee("liangchaowei",51,new MyDate(1970,5,23));
        Employee e4=new Employee("zhangxueyou",48,new MyDate(1976,6,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        TreeSet set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate d1=e1.getBirthday();
                    MyDate d2=e2.getBirthday();

                    return d1.compareTo(d2);
                }
                throw new RuntimeException("輸入類型不一致");
            }
        });
        Employee e1=new Employee("liudehua",55,new MyDate(1966,11,7));
        Employee e2=new Employee("guofucheng",45,new MyDate(1976,5,4));
        Employee e3=new Employee("liangchaowei",51,new MyDate(1970,5,23));
        Employee e4=new Employee("zhangxueyou",48,new MyDate(1970,5,4));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
