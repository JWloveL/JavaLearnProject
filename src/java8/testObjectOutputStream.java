package java8;

import org.junit.Test;

import java.io.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java8
 * @ClassName: testObjectOutputStream
 * @Author: 007
 * @Date: 2021/6/19 14:52
 * @Version: 1.8
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从而允许把这种二进制流持久地保存在磁盘上，或通过网络将
 * 这种二进制流传输到另一个网络节点
 */
public class testObjectOutputStream {

    @Test
    /*
    序列化过程，将内存中的java对象保存到磁盘中通过网络传输出去

    要想一個java對象可以序列化，需要滿足一些要求
     */
    public void test1() throws IOException {

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.dat"));

        oos.writeObject(new String("I love Jesus"));
        oos.flush();

        oos.writeObject(new Person("Jesus",33));
        oos.flush();
        oos.close();
    }

    @Test
    /*
    反序列化，將磁盤文件的對象還原為java裏的一個對象
     */
    public void testObjectInputStream(){
        ObjectInputStream ois=null;
        Object obj= null;
        Object obj1=null;
        try {
            ois=new ObjectInputStream(new FileInputStream("object.dat"));
            obj = ois.readObject();
            String str=(String) obj;
            obj1=ois.readObject();
            Person p=(Person)obj1;
            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
