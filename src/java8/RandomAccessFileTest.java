package java8;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ProjectName: JavaSenior
 * @Package: java8
 * @ClassName: RandomAccessFileTest
 * @Author: 007
 * @Date: 2021/6/19 15:55
 * @Version: 1.8
 *
 * 1.RandomAccessFile直接繼承于java.lang.Object類，實現了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作爲一個輸入流，也可以作爲一個輸出流
 * 3.如果RandomAccessFile作爲輸出流，寫出到的文件如果不存在，則在執行過程中自動創建
 *      如果寫出到的文件存在，則會對原有文件内容進行覆蓋
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1=null;
        RandomAccessFile raf2=null;
        try {
            raf1 = new RandomAccessFile("星空.jpg", "r");
            raf2 = new RandomAccessFile("星空1.jpg", "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                raf2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void test2() throws IOException {

        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);//將指針調到角標為3的位置
        raf1.write("xyz".getBytes());
        raf1.close();
    }
    /*
    使用RandomAccessFile實現數據的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1=new RandomAccessFile("hello.txt","rw");

        raf1.seek(3);
        //保存指針3後面的所有數據到StringBuilder中
        StringBuilder builder=new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer=new byte[20];
        int len;
        while ((len=raf1.read(buffer))!=-1){
            builder.append(new String(buffer,0,len));
        }
        raf1.seek(3);
        raf1.write("xyz".getBytes());

        //將StringBuilder中的數據寫入到文件中
        raf1.write(builder.toString().getBytes());
        raf1.close();
    }
}
