package java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ProjectName: JavaSenior
 * @Package: java2
 * @ClassName: IteratorTest
 * @Author: 007
 * @Date: 2021/6/13 15:59
 * @Version: 1.8
 */

/**
 * Iterator仅用于遍历集合
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator=coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
