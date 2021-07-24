package java10;

/**
 * @ProjectName: JavaSenior
 * @Package: java10
 * @ClassName: Person
 * @Author: 007
 * @Date: 2021/6/21 18:03
 * @Version: 1.8
 */
public class Person {
    private String name;

    private Person(String name) {
        this.name = name;
    }

    public int age;

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

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void show(){
        System.out.println("我爱耶稣！");
    }

    private void showNation(String nation){
        System.out.println("我是"+nation+"人");
    }
}
