package java12;

import exer.Employee;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ProjectName: JavaSenior
 * @Package: java12
 * @ClassName: ConstructorRefTest
 * @Author: 007
 * @Date: 2021/6/24 9:27
 * @Version: 1.8
 *
 * 二：数组引用
 *      大家可以把数组看做是一个特殊的类，则写法和构造器一致
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器
    @Test
    public void test1(){
        Supplier<Employee> sup=new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        Supplier<Employee> sup1=()->new Employee();
        System.out.println(sup1.get());

        Supplier<Employee> sup2=Employee::new;
        System.out.println(sup2.get());
    }
    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer,Employee> func1=age->new Employee(age);
        System.out.println(func1.apply(33));
        System.out.println("***************");
        Function<Integer,Employee> func2=Employee::new;
        System.out.println(func2.apply(23));

    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<String,Integer,Employee> func1=(name,age)->new Employee(name,age);
        System.out.println(func1.apply("Tom", 23));
        System.out.println("***********");
        BiFunction<String,Integer,Employee> func2=Employee::new;
        System.out.println(func2.apply("Jerry", 22));
    }

    //数组引用
    @Test
    public void test4(){
         Function<Integer,String[]> func2=length->new String[length];
        String[] arr1 = func2.apply(4);
        System.out.println(Arrays.toString(arr1));
        System.out.println("********");

        Function<Integer,String[]> func3=String[]::new;
        String[] arr2 = func3.apply(4);
        System.out.println(Arrays.toString(arr2));    }

}
