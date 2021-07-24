package StringTest;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Stringtest {
    /**
     * String字符串，使用一对“”引起来表示
     * 1.String声明为final时,不可被继承
     * 2.String实现了Serialzable接口：表示字符串是支持序列化的
     * 3.String内部定义了final char[] value用于存储字符串数据
     * 4.String:体现不可变的字符序列。简称：不可变性
     *      体现：1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
     * 5.通过字面量的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中
     *
     * 面试题：String s=new String("abc");方式创建对象，在内存中创建了几个对象
     * 一个是堆空间的new结构，另一个是char[]对应的常量池中的数据：“abc”
//     */
    @Test
    public void test1(){
        String s1=new String("abc");
        String s2="abc";
        s1="hello";
        System.out.println(s1);
        System.out.println(s2);
        String s3=s2.replace('a','m');
        System.out.println(s2);
        System.out.println(s3);
    }
    @Test
    public void test2(){
        String s1="javaEE";
        String s2="javaEE";
        String s3=new String("javaEE");
        String s4=new String("javaEE");
        System.out.println(s1.endsWith("EE"));
        System.out.println(s1.startsWith("J"));
        System.out.println(s1.lastIndexOf('E'));
        System.out.println(s1.indexOf("ja"));
        System.out.println(s1.replace('j', 'J'));
        System.out.println(s1.replace("EE", "ee"));
        String str="java.sql.vue";
        String Str[]=str.split("\\.");
        for (int i=0;i< Str.length;i++){
            System.out.println(Str[i]);
        }

    }
    @Test
    public void test3(){
        String s1="java";
        String s2="EE";
        String s3="javaEE";
        String s4="java"+"EE";
        String s5=s1+"EE";
        String s6="java"+s2;
        String s7=s1+s2;
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);
        System.out.println(s5 == s6);
        System.out.println(s3 == s7);

    }
    @Test
    public void test4(){
        String str1="abc123";
        char[] arr=str1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        char[] arr1=new char[]{'h','e','l','l','o'};
        String str2=new String(arr1);
        System.out.println(str2);
    }
    @Test
    public void test5() throws UnsupportedEncodingException {
        String str="弥赛亚";
        byte[] bytes=str.getBytes(StandardCharsets.UTF_8);//使用默认的字符集进行编码
        System.out.println(Arrays.toString(bytes));
        byte[] gbk=str.getBytes("gbk");
        System.out.println(Arrays.toString(gbk));
        System.out.println("****************");
        String str1=new String(bytes);
        System.out.println(str1);
        String str2=new String(gbk);//出现乱码。原因：编码集和解码集不一致
        System.out.println(str2);
        String str3=new String(gbk,"gbk");
        System.out.println(str3);
    }
    String str=new String("good");
    public void change(String str){
        str="test";
    }

    public static void main(String[] args) {
        Stringtest ex=new Stringtest();
        Stringtest st=new Stringtest();
        ex.change(ex.str);
        System.out.println(ex.str);
        System.out.println(st.str == ex.str);
    }
}

