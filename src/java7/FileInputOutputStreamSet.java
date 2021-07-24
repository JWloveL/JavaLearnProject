package java7;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ProjectName: JavaSenior
 * @Package: java7
 * @ClassName: FileInputOutputStreamSet
 * @Author: 007
 * @Date: 2021/6/18 10:55
 * @Version: 1.8
 *
 * 结论:
 * 1.对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,..)使用字节流处理
 */
public class FileInputOutputStreamSet {
    @Test
    public void testFileInputStream() throws IOException {
        //使用字节流FileInputStream处理文本文件，可能出现乱码
        File file=new File("hello.txt");

        FileInputStream fis=new FileInputStream(file);

        byte[] buffer= new byte[5];

        int len;

        while ((len=fis.read(buffer))!=-1){
            String str=new String(buffer,0,len);
            System.out.print(str);
        }

        fis.close();
    }

    @Test
    public void testFileInputOutputStream() throws IOException {
        File srcFile= new File("星空.jpg");
        File destFile=new File("星空1.jpg");

        FileInputStream fis=new FileInputStream(srcFile);
        FileOutputStream fos=new FileOutputStream(destFile);

        byte[] buffer=new byte[5];
        int len;
        while ((len = fis.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fis.close();
        fos.close();

    }

    public void copyFile(String srcPath,String destPath){
        File srcFile= new File(srcPath);
        File destFile=new File(destPath);

        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            fis=new FileInputStream(srcFile);
            fos=new FileOutputStream(destFile);

            byte[] buffer=new byte[1024];
            int len;
            while ((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){

        long start=System.currentTimeMillis();
        String srcPath="job.mp4";
        String destPath="jobs.mp4";
        copyFile(srcPath,destPath);

        long end=System.currentTimeMillis();

        System.out.println("复制操作花费的时间为："+(end-start));
    }
}
