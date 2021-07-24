package java12;

/**
 * 1.Stream关注的是对数据的运算，与CPU打交道
 *    集合关注的是数据的存储，与内存打交道
 *
 * 2.
 * Stream自己不会存储元素
 * Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream
 * Stream操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 *
 * 3.Stream 执行流程
 * Stream的实例化
 * 一系列的中间操作
 * 终止操作
 *
 * 4.说明：
 * 一个中间操作链，对数据源的数据进行处理
 * 一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * @ProjectName: JavaSenior
 * @Package: java12
 * @ClassName: StreamAPITest
 * @Author: 007
 * @Date: 2021/6/24 10:21
 * @Version: 1.8
 */
public class StreamAPITest {
}
