package java11;

/**
 * @ProjectName: JavaSenior
 * @Package: java11
 * @ClassName: StaticProxyTest
 * @Author: 007
 * @Date: 2021/6/22 21:07
 * @Version: 1.8
 */

interface ClothFactory{
    void produceCloth();
}
//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理类做一些回收工作");
        factory.produceCloth();
        System.out.println("代理类做一些收尾工作");
    }
}
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产了耐克");
    }
}

public class StaticProxyTest  {
    public static void main(String[] args) {

        ClothFactory clothFactory=new NikeClothFactory();
        ClothFactory factory=new ProxyClothFactory(clothFactory);
        factory.produceCloth();
    }

}
