package StringTest;

import org.junit.Test;

public class DebugTest {
    @Test
    public void test(){
        String str=null;
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1=new StringBuffer(str);
        System.out.println(sb1);
    }
}
