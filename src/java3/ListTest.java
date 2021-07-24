package java3;

import java.util.LinkedList;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: ListTest
 * @Author: 007
 * @Date: 2021/6/14 8:42
 * @Version: 1.8
 * * |---Collection接口：单列集合，用来存储一个一个的对象
 *  *      |---List接口：存储有序的，可重复的数据
 *  *          |---ArrayList: 作为List接口的主要实现类：线程不安全的，效率高，底层使用Object[]存储
 *             |---LinkedList：对于频繁的插入，删除操作，使用此类效率比ArrayList高，底层使用双向链表存储
 *             |---Vector:作为List接口的古老实现类，线程安全的，效率低，底层使用Object[]存储
 *    ArrayList,LinkedList,Vector三者的异同
 *
 *    ArrayList 源码：默认情况下，扩容为原来的容量的1.5倍，同时将原来数组的数据复制到新数组中
 *    同：每个类都实现了List接口，存储数据的特点相同，存储有序，可重复的数据
 *    不同：见上
 *
 *    jdk 8中ArrayList的变化
 *    ArrayList list=new ArrayList();
 *    list.add(123);//第一次调用add(),底层才创建了长度10的数组
 *
 *    常用方法
 *    增：add(Object obj)
 *    刪：remove(Object obj)
 *    改：set(int index Object obj)
 *    查：get(int index)
 *    刪：remove(int index); remove(Object obj)
 *    長度·：size()
 *    使用· Iterator;foreach;
 */
public class ListTest {
}
