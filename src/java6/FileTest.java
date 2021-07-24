package java6;

import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ProjectName: JavaSenior
 * @Package: java6
 * @ClassName: FileTest
 * @Author: 007
 * @Date: 2021/6/17 9:43
 * @Version: 1.8
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件和文件目录的创建，删除，重命名，修改时间，文件大小
 *   并未涉及到写入或读取文件内容的操作，如果需要读取或写入文件内容，必须使用IO流来完成
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 */
public class FileTest {

    /*
    1.如何创建File类的实例
        File(String filePath)
        File(String parentPath, String childPath)
        File(File parentFile, String childPath)
    2.
    相对路径:相较于某个路径下，指明的路径
    绝对路径:

    3.路径分隔符
        window:\\
        unix:/
     */
    @Test
    public void test1(){
        //构造器1
        File file=new File("hello.txt");
        File file1=new File("D:\\IJProject\\world.txt");
        System.out.println(file);
        System.out.println(file1);
        //构造器2
        File file2=new File("D:\\IJProject0","Java");
        System.out.println(file2);
        //构造器3
        File file3=new File(file2,"oh.txt");
        System.out.println(file3);

    }
    /*
    File 类的常用方法
     */
    @Test
    public void test2(){
        File file1=new File("hello.txt");
        File file2=new File("D:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());//最近修改时间

        System.out.println("-------------------");

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    @Test
    public void test3(){
        File file=new File("D:\\IJProject");

        String[] list=file.list();
        for (String s: list){
            if (s.endsWith(".txt"))
            System.out.println(s);
        }

        File[] files=file.listFiles();

        for (File f: files){

            System.out.println(f);
        }
    }

    /*
    public boolean renameTo(File fest):把文件重命名为指定的文件路径
    比如：file1.renameTo(file2)
    要想保住返回true,file1存在，file2不能存在
     */

    @Test
    public void test4(){

        File file1=new File("hello.txt");
        File file2=new File("D:\\io\\hi.txt");

        System.out.println(file2.renameTo(file1));
    }

    /*
    file类的判断方法
     */

    @Test
    public void test5(){
        File file1=new File("hello.txt");
        file1=new File("Hello1.text");
        System.out.println(file1.isDirectory());//是否是文件目录
        System.out.println(file1.isFile());//是否是文件
        System.out.println(file1.exists());//是否存在
        System.out.println(file1.canRead());//是否可读
        System.out.println(file1.canWrite());//是否可写
        System.out.println(file1.isHidden());//是否隐藏

        File file2=new File("d:\\io");

        System.out.println("--------------------");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    /*
    创建删除功能
     */
    @Test
    public void test6() throws IOException {
        File file=new File("hi.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建成功");
        }
        else {
            file.delete();
            System.out.println("删除成功");
        }


    }

    //文件目录的创建
    @Test
    public void test7(){
        File file1=new File("d:\\io\\io1");

        boolean mkdir=file1.mkdir();
        if (mkdir){
            System.out.println("创建成功");
        }
    }

    @Test
    public void test8(){
        //文件目录的创建，mkdirs，一并创建
        File file1=new File("d:\\io\\io2\\io3");
        boolean mkdir=file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }
        File file2=new File("d:\\io\\io2\\io4");
        boolean mkdirs=file2.mkdirs();
        if(mkdirs){
            System.out.println("创建成功2");
        }
        //要想删除成功，io4文件目录不能有子目录或文件
        File file3=new File("d:\\io\\io2\\io4");
        System.out.println(file3.delete());
    }
}
