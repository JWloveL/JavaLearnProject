package java7;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ProjectName: JavaSenior
 * @Package: java7
 * @ClassName: PicTest
 * @Author: 007
 * @Date: 2021/6/18 16:09
 * @Version: 1.8
 */
public class PicTest {
    //图片的加密
    @Test
    public void test1() throws IOException {

        FileInputStream fis=new FileInputStream("星空1.jpg");
        FileOutputStream fos=new FileOutputStream("星空2.jpg");

        byte[] buffer=new byte[20];
        int len;
        while ((len=fis.read(buffer))!=-1){
            for (int i = 0; i < len; i++) {
                buffer[i]= (byte) (buffer[i]^5);
            }
            fos.write(buffer,0,len);
        }

        fos.close();
        fis.close();
    }
}
