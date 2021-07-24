package java1;

/**
 * 注解的使用
 *
 * 1.理解Annotation
 * 其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行被读取
 *
 * 2.Annocation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查
 * @Override 重写
 * @Deprecated 过时
 * @SuppressWarnings 抑制警告
 *
 * 3.自定义注解
 * @interface
 * 内部定义成员，通常使用value表示
 * 4.jdk 提供的4种元注解
 * 元注解：对现有的注解进行解释说明的注解
 * Retention:指定所修饰的Annotation的生命周期： SOURCE\CLASS(默认行为)
 * 只有声明为RUNTIME声明周期的注解，才能通过反射获取
 * Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
 * Documented:表示所修饰的注解被javadoc 保留下来
 * Inherited:被它修饰的Annotation 将具有继承性
 *
 * 5.jdk 8 中注解的新特性：可重复注解，类型注解
 * 可重复注解：1.在MyAnnotation声明@
 */
public class AnnotationTest {
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public void walk(){
        System.out.println("人走路");
    }
}
interface Info{
    void show();
}
class Student extends Person{

    public void walk(){
        System.out.println("学生走路");
    }
}
