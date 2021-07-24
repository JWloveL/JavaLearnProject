package java7;

import org.junit.Test;

import java.io.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java7
 * @ClassName: FileReaderWriterTest
 * @Author: 007
 * @Date: 2021/6/17 17:24
 * @Version: 1.8
 *
 * 抽象基类          节点流               缓冲流
 * InputStream      FileInputStream (read(byte[] buffer))           BufferdInputStream(read(byte[] buffer))
 * OutputStream     FileOutputStream  (write(byte[] buffer,0,len)   BufferedOutputStream(write(byte[] buffer,0,len))
 * Reader           FileReader (read(char[] cbuf))                  BufferedReader(read(char[] cbuf))
 * Writer           FileWriter (write(char[] cbuf,0,len))           BufferedWriter(write(char[] cbuf,0,len))/flush()
 */
/*
异常处理，为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally
读入的文件一定要存在，否则就会报FileNotFoundException
 */
public class FileReaderWriterTest {
    @Test
    public void FileReaderTest() {
        //1.实例化File类的对象，指明要操作的文件
        FileReader fr=null;
        try{
        File file=new File("hello.txt");
        //2.提供具体的值
        fr=new FileReader(file);
        //3.数据的读入，如果达到文件末尾，返回-1
        //方式一
//        int data=fr.read();
////        while (data!=-1){
////            System.out.println((char)data);
////            data=fr.read();
////        }
        //方式二
        int data;
        while ((data=fr.read())!=-1){
            System.out.println((char)data);
        }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    @Test
    //对read()操作升级，使用read的重载方法
    public void testFileReader1() throws IOException {
        //1.File类的实例化
        File file=new File("hello.txt");
        //2.FileReader流的实例化
        FileReader fr=new FileReader(file);
        //3.读入的操作
        char[] cbuf=new char[5];
        int len;
        while ((len = fr.read(cbuf))!=-1){
            //错误的写法
//            for (int i=0;i<cbuf.length;i++){
//                System.out.println(cbuf[i]);
//            }
            //正确的写法
            for (int i=0;i<len;i++){
                System.out.print(cbuf[i]);
            }
            //方式二
            String str= new String(cbuf,0,len);
            System.out.println(str);
        }
        //4.资源的关闭
        fr.close();
    }
    /*
    从内存中写出数据到硬盘的文件里
    说明：
    1.输出操作，对应的File可以不存在，并不会报异常
        如果不存在，在输出的过程中，会自动创建此文件
        如果存在，如果流使用的构造器是：
        FileWriter(file,false)/FileWriter(file)，对原有文件覆盖
        FileWriter(file,true):不会对原有文件覆盖，而是在其上追加内容

     */
    @Test
    public void testFileWriter() throws IOException {
        //1.提供File类的对象，指明写出到的文件
        File file=new File("Hello1.txt");

        //2.提供FileWriter的对象，用于数据的写出
        FileWriter fw=new FileWriter(file,true);

        //3.写出的操作
        fw.write("Hosanna\n");
        fw.write("I will call upon your name");

        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() throws IOException {
        //1.创建file类的对象，指明读入和写入的文件
        File srcFile= new File("hello.txt");
        File destFile= new File("hello2.txt");

        //2.创建输入流和输出流的对象
        FileReader fr=new FileReader(srcFile);
        FileWriter fw=new FileWriter(destFile);

        //3.数据的读入和写出
        char[] cbuf=new char[5];
        int len;
        while ((len=fr.read(cbuf))!=-1){
            fw.write(cbuf,0,len);
        }
        //4.关闭流资源
        fw.close();
        fr.close();
    }
    @Test
    public void test3() throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(new File("hello.txt")));
        BufferedWriter bw=new BufferedWriter(new FileWriter(new File("hello4.txt")));

        String str;
        while ((str=br.readLine())!=null){
            bw.write(str);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}

