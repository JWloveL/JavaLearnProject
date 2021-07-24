package enum1;

/**
 * 一.枚举类的使用
 * 1.枚举类的理解：类的对象只有有限个，确定的。我们称此类为枚举类
 * 2.当需要定义一组常量，强烈使用枚举类
 * 3.如果枚举类中只有一个对象，则可以作为单例模式的实现方式
 *
 * 二.如何定义枚举类
 * 方式一：jdk5.0之前，自定义枚举类
 * 方式二：jdk5.0，可以使用enum关键字定义枚举类
 * 三.Enum类的主要方法
 *      values()方法：返回枚举类型的对象数组，该方法可以方便地遍历数组
 * 四：使用enum关键字实现接口
 *
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 spring=Season1.SPRING;
        System.out.println(spring);
        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        Season1 winter= Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}
interface Info{
    void show();
}
enum Season1 implements Info{
    //声明Season对象的属性
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天里");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋风送爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    private final String seasonName;
    private final String seasonInfo;
    private Season1(String seasonName,String seasonInfo){
        this.seasonName=seasonName;
        this.seasonInfo=seasonInfo;
    }

    //3.提供当前枚举类的多个对象


}
