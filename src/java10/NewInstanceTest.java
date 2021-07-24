package java10;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * @ProjectName: JavaSenior
 * @Package: java10
 * @ClassName: NewInstanceTest
 * @Author: 007
 * @Date: 2021/6/22 10:44
 * @Version: 1.8
 */

public class NewInstanceTest {
    @Test
    //体会反射的动态性
    public void test2() {
        for (int i = 0; i < 10; i++) {


            String classPath = "";
            int num = new Random().nextInt(3);
            switch (num) {
                case 0:
                    classPath = "java.lang.Object";
                    break;
                case 1:
                    classPath = "java.util.Date";
                    break;
                case 2:
                    classPath = "java10.Person";
                    break;
            }
            Object obj = null;
            try {
                obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /*
    创建一个指定类的对象
     */
    public Object getInstance(String classPath) throws Exception{
        Class clazz=Class.forName(classPath);
        return clazz.newInstance();
    }

    @Test
    //开发时不常用
    public void testField() throws Exception{
        Class clazz=Person.class;
        Person p = (Person) clazz.newInstance();
        //获取指定属性,要求指定类属性声明为public
        Field name=clazz.getField("name");
        name.setAccessible(true);
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }
    @Test
    public void testField1() throws Exception{
        Class clazz=Person.class;

        //创建运行时类的对象
        Person p=(Person) clazz.newInstance();

        Field name=clazz.getDeclaredField("name");

        name.setAccessible(true);

        name.set(p,"Tim");
        System.out.println(name.get(p));
    }
    @Test
    public void testMethod() throws Exception{
        Class clazz=Person.class;
        Person p=(Person) clazz.newInstance();
//1.获取指定的某个方法 getDeclaredMethod():参数1：指明获取的方法的名称  参数2：指明获取的方法的形参列表
        Method show=clazz.getDeclaredMethod("showNation", String.class);


        //2.保证该方法是可访问的
        show.setAccessible(true);
        /*
       3. invoke():参数1：方法的调用者，参数2：给方法形参赋值的实参
         */
        show.invoke(p,"CHN");

        Method show1=clazz.getDeclaredMethod("show");
        show1.setAccessible(true);
        Object o = show1.invoke(null);
        System.out.println(o);
    }
}
