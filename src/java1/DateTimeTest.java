package java1;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
    java.util.Data类
        |---java.sql.Date类
    1.两个构造器的使用

    2.两个方法的使用

    3.java.sql.Date对应着数据库里日期类型的变量
 */
public class DateTimeTest {
    //1.System类中的currentTimeMillis
    @Test
    public void test2() {
        //构造器一：Date()
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二：
        Date date2 = new Date(1623158667855L);
        System.out.println(date2.toString());

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一
        Date date4 = new java.sql.Date(2345322335235L);
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());

    }

    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //称为时间戳
        System.out.println(time);
    }

    @Test
    public void test3() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期---->字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);
        //字符串-->日期
        String str = "19-12-18 上午11:43";
        Date date1 = sdf.parse(str);
        System.out.println(str);
        //按照指定的方式格式化
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1= sdf1.format(date);
        System.out.println(format1);
        //解析 要求字符串必须符合SimpleDateFormat的格式
        Date date2=sdf1.parse("2034-03-23 12:34:12");
        System.out.println(date2);
    }
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建器子类对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar=Calendar.getInstance();
        //2.常用方法
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);

        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        //getTime()
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}