package exer1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: JavaSenior
 * @Package: exer1
 * @ClassName: StudentTest
 * @Author: 007
 * @Date: 2021/6/16 11:14
 * @Version: 1.8
 */
public class StudentTest {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(new Student("Job",98));
        list.add(new Student("Maria",93));
        list.add(new Student("Peter",92));
        list.add(new Student("Daniel",94));
        list.add(new Student("Juda",59));
        list.add(new Student("Paul",95));
        Collections.sort(list);
        for(Object obj: list){
            Student s=(Student) obj;
            System.out.println(s.getScore());
        }
    }
}
