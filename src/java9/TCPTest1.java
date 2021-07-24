package java9;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName: JavaSenior
 * @Package: java9
 * @ClassName: TCPTest1
 * @Author: 007
 * @Date: 2021/6/21 9:23
 * @Version: 1.8
 */
public class TCPTest1 {
    //客戶端
    @Test
    public void client() throws IOException {

        InetAddress inet=InetAddress.getByName("127.0.0.1");
        //指明服務器端ip和端口號
        Socket socket=new Socket(inet,8899);
        OutputStream os = socket.getOutputStream();
        //獲取一個輸出流，用於輸出數據
        os.write("我是客戶端hh".getBytes());
        os.close();
        socket.close();
    }

    //服務端
    @Test
    public void server() throws IOException {
        //創建服務器端的ServerSocket,指明自己的端口號
        ServerSocket s = new ServerSocket(8899);
        //調用accept()表示接受來自于客戶端的socket
        Socket socket=s.accept();

        InputStream is= socket.getInputStream();
        //不建議這樣寫，可能有亂碼
//        byte[] buffer=new byte[20];
//        int len;
//        while ((len=is.read(buffer))!=-1){
//            String str=new String(buffer,0,len);
//            System.out.println(str);
//        }
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer=new byte[5];
        int len;
        while ((len=is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        System.out.println(socket.getInetAddress().getHostAddress());
        baos.close();
        is.close();
        socket.close();
        s.close();
    }
}
