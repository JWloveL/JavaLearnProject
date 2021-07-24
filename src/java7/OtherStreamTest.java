package java7;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ProjectName: JavaSenior
 * @Package: java7
 * @ClassName: OtherStreamTest
 * @Author: 007
 * @Date: 2021/6/18 21:27
 * @Version: 1.8
 *
 * System.in 是字节流
 */
public class OtherStreamTest {

    @Test
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String data;
        while (true){
            System.out.println("请输入字符串: ");
            data=br.readLine();
            if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                System.out.println("程序结束");
                break;
            }

            String upperCase=data.toUpperCase();
            System.out.println(upperCase);
        }
        br.close();
    }


}
