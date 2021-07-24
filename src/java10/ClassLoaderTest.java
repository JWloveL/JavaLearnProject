package java10;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ProjectName: JavaSenior
 * @Package: java10
 * @ClassName: ClassLoaderTest
 * @Author: 007
 * @Date: 2021/6/22 10:24
 * @Version: 1.8
 */
public class ClassLoaderTest {
    @Test
    //使用ClassLoader默认识别为module的src下
    public void test2() throws IOException {
        Properties pros=new Properties();
        ClassLoader classLoader=ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);
        String user=pros.getProperty("name");
        String password= pros.getProperty("password");
        System.out.println(user);
        System.out.println(password);
    }
}
