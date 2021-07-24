package java9;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @ProjectName: JavaSenior
 * @Package: java9
 * @ClassName: TCPTest2
 * @Author: 007
 * @Date: 2021/6/21 10:23
 * @Version: 1.8
 */
public class TCPTest2 {
    @Test
    public void client() throws IOException {
        Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9090);

        OutputStream os = socket.getOutputStream();

        FileInputStream fis=new FileInputStream(new File("星空.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //關閉數據的輸出
        socket.shutdownOutput();
        //接收來自服務端的數據
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        byte[] buffer1=new byte[20];
        int len1;
        while ((len1=is.read(buffer1))!=-1){
            bos.write(buffer,0,len1);
        }
        System.out.println(bos.toString());
        fis.close();
        os.close();
        socket.close();
        bos.close();
        is.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss=new ServerSocket(9090);
        Socket s = ss.accept();
        InputStream is=s.getInputStream();

        FileOutputStream fos=new FileOutputStream(new File("星空3.jpg"));
        byte[] buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        System.out.println("the picture has been transferred");
        OutputStream os = s.getOutputStream();
        os.write("圖片收到，很好!".getBytes("gbk"));

        fos.close();
        is.close();
        s.close();
        ss.close();
        os.close();
    }
}
