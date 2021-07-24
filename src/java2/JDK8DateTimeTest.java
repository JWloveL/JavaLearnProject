package java2;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class JDK8DateTimeTest {
    /**
     * LocalDate,LocalTime,LocalDateTime
     */
    @Test
    public void test1(){
        //获取当前时间
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println("*************");
        //of():设置指定的年月日时分秒。没有偏移量
        LocalDateTime localDateTime1=LocalDateTime.of(2020,10,7,13,32,23);
        System.out.println(localDateTime1);
        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx()
        LocalDate localDate1=localDate.withMonth(7);
        System.out.println(localDate1);

        LocalTime localTime1=localTime.withHour(23);
        System.out.println(localTime1);

        //
        System.out.println(localDateTime.plusDays(32));

        System.out.println(localDateTime.minusMonths(3));
    }

    /**
     * Instant的使用
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取对应的毫秒数
        long milli=instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli(),通过给定的毫秒数，获取Instant实例 -->Date类的get
        Instant instant1=Instant.ofEpochMilli(1623401846419L);
        System.out.println(instant1);
    }
    @Test
    public void test3(){
        //方式一：预定义的标准格式。如：ISO_LOCAL_DATE_TIME; ISO_LOCAL_DATE
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //日期-->字符串
        LocalDateTime localDateTime=LocalDateTime.now();
        String str1=formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //字符串-->日期
        TemporalAccessor parse=formatter.parse("2021-06-11T17:22:57.824");
        System.out.println(parse);

        //自定义格式化
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str2=formatter1.format(LocalDateTime.now());
        System.out.println(str2);
    }
}
