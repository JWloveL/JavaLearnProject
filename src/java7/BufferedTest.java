package java7;

import org.junit.Test;

import java.io.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java7
 * @ClassName: BufferedTest
 * @Author: 007
 * @Date: 2021/6/18 15:06
 * @Version: 1.8
 *
 * 缓冲流作用:提高流的读取，写入的速度
 * 提高速度的原因：提供了一个缓冲区
 */
public class BufferedTest {
    @Test
    public void BufferedStreamTest() throws IOException {
        //1.造文件
        File srcFile=new File("星空.jpg");
        File destFile=new File("星空2.jpg");
        //2.造流
        FileInputStream fis=new FileInputStream(srcFile);
        FileOutputStream fos=new FileOutputStream(destFile);

        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos=new BufferedOutputStream(fos);

        byte[] buffer=new byte[10];
        int len;
        while ((len= bis.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }
        bis.close();
        bos.close();
    }
}
