package java6;

import org.junit.Test;

import java.io.File;

/**
 * @ProjectName: JavaSenior
 * @Package: java6
 * @ClassName: ListFilesTest
 * @Author: 007
 * @Date: 2021/6/17 11:19
 * @Version: 1.8
 */
public class ListFilesTest {
    @Test
    public void test1(){
        File dir=new File("D:\\IJProject\\myProject3");

        //2.打印目录的子文件
        printSubFile(dir);
        System.out.println(getDirectorySize(dir));
    }

    public static void printSubFile(File dir){
        File[] files=dir.listFiles();

        for (File file:files){
            if(file.isDirectory()){
                printSubFile(file);
            }
            else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public long getDirectorySize(File file){
        long size=0;
        if (file.isFile()){
            size+=file.length();
        }
        else {
            File[] files=file.listFiles();
            for (File all: files){
                size+= getDirectorySize(all);
            }
        }
        return size;
    }
}
