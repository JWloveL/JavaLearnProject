package java3;

import java.util.Objects;

/**
 * @ProjectName: JavaSenior
 * @Package: java3
 * @ClassName: Person
 * @Author: 007
 * @Date: 2021/6/14 10:43
 * @Version: 1.8
 */
public class Person implements Comparable
{
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Equals---");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p=(Person) o;
            int compare= this.name.compareTo(p.name);
            if (compare==0){
                return Integer.compare(this.age,p.age);
            }
            else {
                return compare;
            }
        }
        else {
            throw new RuntimeException("輸入類型不匹配");
        }
    }
}
