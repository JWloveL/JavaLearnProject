package java11;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: JavaSenior
 * @Package: java11
 * @ClassName: DynamicProxyTest
 * @Author: 007
 * @Date: 2021/6/22 21:23
 * @Version: 1.8
 */
interface Human{
    String getBelief();

    void eat(String food);
}
//被代理类
class Christian implements Human{

    @Override
    public String getBelief() {
        return "I believe Jesus";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }
}
/*
要想实现动态代理，需要解决的问题？
问题1：如何根据加载到内存中的被代理类，动态创建一个代理类及其对象
问题2：当通过代理类的对象调用方法时，如何动态的调用被代理类中的同名方法
 */
class ProxyFactory{
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler=new MyInvocationHandler();
        handler.bind(obj);
        return  Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }
    //当我们通过代理类的对象，调用方法a，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能就声明在invoke（）中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，也就作为了被代理类调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}
public class DynamicProxyTest {
    public static void main(String[] args) {
        Christian christian=new Christian();
        //代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(christian);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("羊肉串");
        NikeClothFactory nikeClothFactory=new NikeClothFactory();
        ClothFactory instance = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        instance.produceCloth();
    }
}
