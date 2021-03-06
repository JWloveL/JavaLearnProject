package java10;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: JavaSenior
 * @Package: java10
 * @ClassName: ReflectionTest
 * @Author: 007
 * @Date: 2021/6/21 18:03
 * @Version: 1.8
 */
public class ReflectionTest {
    @Test
    public void test1(){

        //1.创建Person类的对象
        Person p1=new Person("Tom",12);

        p1.age=10;
        System.out.println(p1.toString());

        p1.show();
    }
    //反射之后，对于Person的操作
    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class clazz=Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj=cons.newInstance("Tom",12);
        Person p=(Person) obj;
        System.out.println(p.toString());

        Field age=clazz.getDeclaredField("age");
        age.set(obj,10);
        System.out.println(p.toString());

        //调用方法
        Method show=clazz.getDeclaredMethod("show");
        show.invoke(p);

        //调用私有的构造器
        Constructor cons1=clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1=(Person) cons1.newInstance("Jerry");
        System.out.println(p1);
        //调用私有的属性
        Field name=clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeiMei");
        System.out.println(p1);
        //调用私有方法
        Method Nation=clazz.getDeclaredMethod("showNation",String.class);
        Nation.setAccessible(true);
        String nation= (String) Nation.invoke(p1,"中国");
        System.out.println(nation);
    }
    //疑问：通过直接new的方式或反射的方式都可以调用公共的结构，开发到底用哪个？
    //建议：直接new的方式
    //什么时候会使用：反射的方式。反射的特征，动态性
    //疑问：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术

    /*
    关于java.lang.Class类的理解
    1.类的加载过程
    程序经过javac.exe命令后，会生成一个或多个字节码文件（.class结尾），接着我们使用
    java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。
    此过程就称为类的加载。加载到内存中的类，我们就称为运行时类，此运行时类，就作为Class的一个实例
    Class就对应着一个运行时类
    2.换句话说，Class的实例就对应着一个运行时类
    3.加载到内存中的运行时类，会缓存一定的时间。在此时间之内，我们通过不同的方式来获取此运行时类
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一：调用运行时类的属性
        Class clazz1=Person.class;
        System.out.println(clazz1);
        //方式二：通过运行时类的对象，调用getClass()
        Person p1=new Person();
        Class clazz2=p1.getClass();
        System.out.println(clazz2);
        //方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3=Class.forName("java10.Person");
//        Class clazz3=Class.forName("java.lang.String");
        System.out.println(clazz3);
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        //方式四：使用类的加载器：ClassLoader(了解）
        ClassLoader classLoader=ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("java10.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);
    }
}
