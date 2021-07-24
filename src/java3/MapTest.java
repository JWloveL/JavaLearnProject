package java3;

import org.junit.Test;

import java.util.*;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: MapTest
 * @Author: 007
 * @Date: 2021/6/15 16:25
 * @Version: 1.8
 *
 * |---Map:雙列數據，存儲key-value對數據  ---類似于高中的函數：y=f(x)
 *      |---HashMap:作爲Map的主要實現類：綫程不安全的，效率高,存儲null的key和value
 *          |--LinkedHashMap:保證在遍歷map元素時，可以按照添加的順序實現遍歷
 *              原因：在原有的HashMap底層結構基礎上，添加了一對指針，指向前一個后后一個
 *      |---TreeMap：保證按照添加的key-value對進行排序，實現排序遍歷，此時考慮key的自然排序或定制排序，底層使用紅黑樹
 *      |---HashTable:作爲古老的實現類：綫程安全的，效率低,不能存儲null的key和value
 *          |---Properties:常用來處理配置文件
 *
 *      HashMap的底層：數組+鏈表 （jdk7 及之前）
 *                    數組+鏈表+紅黑樹 （jdk 8)
 *
 *      面試題：
 *      1.HashMap的底層實現原理?
 *      2.HashMap 和 Hashtable的異同？
 *
 *      二。Map結構的理解
 *      Map中的key:無序的，不可重複的，使用Set存儲所有的可以,key所在類要重寫equals()和hashcode()
 *      Map中的Value:無序的，可重複的，使用Collection存儲所有的value
 *      一個鍵值對： key-value構成了一個Entry對象
 *      Map中的entry：無序的，不可重複的，使用Set存儲所有的entry
 *
 *      三.HashMap的底層實現原理？ 以jdk7爲例説明
 *      HashMap map=new HashMap();
 *      在實例化以後，底層創建了長度是16的一維數組Entry[] table;
 *      ...可能已經執行過多次put...
 *      map.put(key1,value1);
 *      首先，調用key1所在類的hashCode()計算key1哈希值，此哈希值經過某種算法計算以後，得到在Entry數組中的存放位置
 *      如果此位置上的數據爲空，此時key1-value1添加成功 ---情況1
 *      如果此位置上的數據不爲空，（意味著此位置存在一個或多個數據）（以鏈表形式存在），比較key1和已經存在的一個或多個數據的哈希值
 *              如果key1的哈希值與已經存在的數據的哈希值都不相同，此時key1-value1添加成功
 *              如果key1的哈希值和已經存在的某一個數據（key2-value2）的哈希值相同，繼續比較：調用key1所在類的equals方法，比較：
 *                  如果equals()返回false:此時key1-value1添加成功
 *                  如果equals()返回true:使用value1替換相同key的value值
 *
 *       在不斷的添加過程中，會涉及到擴容的方式：擴容為原來容量的2唄，并將原有的數據複製過來
 *
 *       jdk8 相較於jdk7在底層實現方面的不同
 *       1.new HashMap():底層沒有創建一個長度為16的數組
 *       2.jdk 8底層的數組是：Node[], 而非Entry[]
 *       3.首先調用put()方法時，底層創建長度為16的數組
 *       4.jdk7底層結構只有：數組加鏈表
 *       jdk8中底層結構：數組+鏈表+紅黑樹
 *       儅數組的某一個索引位置的元素以鏈表形式存在的數據個數>8且當前數組的長度>64
 *       此時此索引位置上的所有數據改爲紅黑樹存儲
 *
 *       五.Map定义的方法
 *       添加，删除修改：
 *       Object put(Object key, Object value);
 *       void putAll(Map m)
 *       Object remove(Object key)
 *       void clear()
 *
 *       查询
 *       Object get(Object key):获取指定key对应的value
 *       boolean containsKey(Object key):是否包含指定的key
 *       boolean containsValue(Object value)是否包含指定的value
 *       int size()
 *       boolean isEmpty()
 *       boolean equals(Object obj)
 *
 *
 */
public class MapTest {
    @Test
    public void test1(){
        Map map=new HashMap();

        map.put("AA",21);
        map.put(45,21);
        map.put("df",21);

        System.out.println(map);

        Map map1 = new HashMap<>();
        map1.put("cc",22);
        map1.put("dd",22);
        map.putAll(map1);

        System.out.println(map.containsKey("AA"));
        System.out.println(map.containsValue(22));

        System.out.println(map);

        //remove(Object key)
        Object value=map.remove("cc");
        System.out.println(value);

        //clear()
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
        System.out.println(map.isEmpty());
    }
    @Test
    public void test2(){
        Map map=new HashMap();

        map.put("AA",21);
        map.put(45,21);
        map.put("df",21);
//        修改
        map.put("AA",34);
        //遍历所有的key集：keySet()
        Set set=map.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历所有的value集：values()
        Collection values=map.values();
        for (Object obj:
             values) {
            System.out.println(obj);
        }

        //遍历所有的key-value
        //entrySet():
        //方式一
        Set<Map.Entry> entrySet = map.entrySet();
        Iterator<Map.Entry> iterator1=entrySet.iterator();
        while (iterator1.hasNext()){
            Map.Entry entry=iterator1.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        //方式二
        Set set1=map.keySet();
        Iterator iterator2=set1.iterator();
        while (iterator2.hasNext()){
            Object key=iterator2.next();
            Object v=map.get(key);
            System.out.println(key+"==="+v);
        }
    }
}
