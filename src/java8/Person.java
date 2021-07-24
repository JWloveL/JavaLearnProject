package java8;

import java.io.Serializable;

/**
 * @ProjectName: JavaSenior
 * @Package: java8
 * @ClassName: Person
 * @Author: 007
 * @Date: 2021/6/19 15:07
 * @Version: 1.8
 *
 * 可序列化：實現Serializable接口
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修飾的成員變量
 */
public class Person implements Serializable {
    public static final long serialVersionUID=353245212343L;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
