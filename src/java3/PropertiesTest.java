package java3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: PropertiesTest
 * @Author: 007
 * @Date: 2021/6/16 10:33
 * @Version: 1.8
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception {
        Properties pros=new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);
        String name=pros.getProperty("name");
        String age=pros.getProperty("age");
        System.out.println(name);
        System.out.println(age);
    }
}
