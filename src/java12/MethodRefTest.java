package java12;

import exer.Employee;
import exer.MyDate;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ProjectName: JavaSenior
 * @Package: java12
 * @ClassName: MethodRefTest
 * @Author: 007
 * @Date: 2021/6/23 21:58
 * @Version: 1.8
 *
 * 方法引用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同!
 */
public class MethodRefTest {
    //情况一：对象::实例方法
    //Consumer中的void accept(T t)
    @Test
    public void test1(){
        Consumer<String> con1=str-> System.out.println(str);
        con1.accept("北京");
        System.out.println("**************");
        PrintStream ps=System.out;
        Consumer<String> con2=ps::println;
        con2.accept("beijing");
    }
    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){
        Employee emp=new Employee("Tom",29,new MyDate(1992,3,12));

        Supplier<String > sup1=()-> emp.getName();
        System.out.println(sup1.get());

        System.out.println("****************");

        Supplier<String > sup2=emp::getName;
        System.out.println(sup2.get());
    }
    //情况二：类::静态方法
    //Comparator中的 int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> com1=(t1,t2)->Integer.compare(t1,t2);
        System.out.println(com1.compare(23, 12));
        System.out.println("*****************");

        Comparator<Integer> com2=Integer::compare;
        System.out.println(com2.compare(23, 12));

    }
    //Function中的 R apply(T t)
    //Math中Long round(Double d)
    @Test
    public void test4(){
        Function<Double,Long> func1=d->Math.round(d);
        System.out.println(func1.apply(12.3));
        System.out.println("*************");
        Function<Double,Long> func2=Math::round;
        System.out.println(func2.apply(21.3));
    }
    //情况三：类 :: 实例方法 （有难度）
    //Comparator中的int compare(T t1,T t2)
    //String中的 int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com1=(s1,s2)->s1.compareTo(s2);
        System.out.println(com1.compare("and", "ant"));
        Comparator<String> com2=String::compareTo;
        System.out.println(com2.compare("sit", "sin"));

    }
    //BiPredicate中的boolean test(T t1,T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> pre1=(s1,s2)->s1.equals(s2);
        System.out.println(pre1.test("asd", "asd"));
        BiPredicate<String,String> pre2=String::equals;
        System.out.println(pre2.test("dfd", "dfm"));
    }

    //Function中的R apply(T t)
    //Employee中的String getName();
    @Test
    public void test7(){
        Employee employee=new Employee("Jerry",23,new MyDate(1993,4,3));
        Function<Employee,String> func1=e->e.getName();
        System.out.println(func1.apply(employee));
        Function<Employee,String> func2=Employee::getName;
        System.out.println(func2.apply(employee));
    }
}
