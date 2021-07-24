package java9;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ProjectName: JavaSenior
 * @Package: java9
 * @ClassName: InetAddressTest
 * @Author: 007
 * @Date: 2021/6/21 8:55
 * @Version: 1.8
 */
public class InetAddressTest {

    public static void main(String[] args) {
        try {
            InetAddress inet1=InetAddress.getByName("192.168.10.14");
            System.out.println(inet1);

            InetAddress inrt2=InetAddress.getByName("127.0.0.1");
            System.out.println(inrt2);

            InetAddress inet3=InetAddress.getLocalHost();
            System.out.println(inet3);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
