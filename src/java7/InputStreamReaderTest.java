package java7;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *      InputStreamReader:将一个字节的输入流转换为字符的输入流
 *      OutputStreamReader：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流的转换
 *
 * 3.解码：字节，字节数组 --->字符数组，字符串
 *   编码：字符数组，字符串 --->字节，字节数组
 *
 * 4.字符集
 * ASCII:美国标准信息交换码
 *      用一个字节的7位可以表示
 * ISO8859-1:拉丁码表。欧洲码表
 * 用一个字节的8位表示
 * GB2312:中国的中文编码表。最多两个字节的编码表
 * GBK:中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
 * Unicode:国际标准码，融合了目前人类使用的所有字符
 * UTF-8:变长的编码方式，可用1-4字节来表示一个字符
 *
 * @ProjectName: JavaSenior
 * @Package: java7
 * @ClassName: InputStreamReaderTest
 * @Author: 007
 * @Date: 2021/6/18 16:25
 * @Version: 1.8
 */
public class InputStreamReaderTest {
    @Test
    public void test1() throws IOException {

        FileInputStream fis=new FileInputStream("hello.txt");
        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");//使用系统默认的字符串

        char[] cbuf=new char[20];
        int len;
        while ((len=isr.read(cbuf))!=-1){
            String str=new String(cbuf,0,len);
            System.out.println(str);
        }
        isr.close();
    }

    @Test
    public void test2() throws IOException {
        //1.造文件，造流
        File file1=new File("hello.txt");
        File file2=new File("hello_gbk.txt");

        FileInputStream fis=new FileInputStream(file1);
        FileOutputStream fos=new FileOutputStream(file2);

        InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
        OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");

        char[] cbuf=new char[20];
        int len;
        while ((len=isr.read(cbuf))!=-1){
            osw.write(cbuf,0,len);
        }
        isr.close();
        osw.close();
    }
}
