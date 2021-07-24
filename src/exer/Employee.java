package exer;

import java.util.Comparator;
import java.util.Date;

/**
 * @ProjectName: JavaSenior
 * @Package: exer
 * @ClassName: Employee
 * @Author: 007
 * @Date: 2021/6/15 15:17
 * @Version: 1.8
 */
public class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Employee(name,age)...");
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
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

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee(int age) {
        this.age = age;
        System.out.println("Employee(age)....");
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee() {
        System.out.println("***********");
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e=(Employee) o;
            return this.name.compareTo(e.name);
        }
        else {
            throw new RuntimeException("輸入類型不一致");
        }
    }
}
