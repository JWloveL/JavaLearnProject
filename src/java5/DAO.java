package java5;

import java.util.List;

/**
 * @ProjectName: JavaSenior
 * @Package: java5
 * @ClassName: DAO
 * @Author: 007
 * @Date: 2021/6/16 21:13
 * @Version: 1.8
 */
public class DAO<T> {//表的共性操作

    //添加一条记录
    public void add(T t){

    }
    //删除一条记录
    public boolean remove(int index){

        return false;
    }
    //修改一条记录
    public void update(int index, T t){

    }

    //查询一条记录
    public T getIndex(int index){
        return null;
    }
    //查询多条记录

    public List<T> getForList(int index){
        return null;
    }

    //举例：获取表中一共有多少条记录？获取最大的员工入职时间
    public <E> E getValue(){

        return null;
    }
}
