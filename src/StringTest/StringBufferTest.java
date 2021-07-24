package StringTest;

import org.junit.Test;

public class StringBufferTest {
    /**
     * String,StringBuffer,StringBuilder三者异同
     * String:不可变的字符序列
     * StringBuffer:可变的字符序列，线程安全的，但效率较低
     * StringBuilder:可变的字符序列，线程不安全的，效率高
     *
     * 源码分析：
     * String str=new String();//new char[0]
     * String str1=new String("abc“);
     * StringBuffer sb1=new StringBuffer();//char[] value=new char[16];
     * sb1.append('a');
     * sb2.append('b');//value[1]='b'
     *
     * 问题1：System.out.println(sb1.length());//3
     * 问题2：扩容问题：如果要添加的数据底层数组盛不下了
     *       默认情况下，扩容为原来容量的2倍＋2，同时将原有数组的元素复制到新的数组
     *       指导意见：开发中建议大家使用：StringBuffer(int capacity)
     *
     *       总结：
     *       增：append(xxx)
     *       删：delete(int start, int end)
     *       改：setCharAt(int n,char ch) / replace(int start,int end, String str)
     *       查：charAt(int n)
     *       插：insert(int offset, xxx)
     *       长度：length()
     *       遍历：for + charAt()
     *
     *       对比String,StringBuffer,StringBuilder三者的效率
     *       从高到低排列：StringBuilder > StringBuffer > String
     * */
    @Test
    public void test1(){
        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
    }
    @Test
    public void test2(){
        StringBuffer s1=new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        s1.delete(2,4);
        s1.insert(2,"do");
        s1.reverse();
        System.out.println(s1);

    }
}
