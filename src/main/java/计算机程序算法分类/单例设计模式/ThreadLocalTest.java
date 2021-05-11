package 计算机程序算法分类.单例设计模式;

/**
 * @Classname ThreadLocalTest
 * @Description TODO
 * @Date 2021/5/11 10:11
 * @Created by xjl
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> localName = new ThreadLocal<>();
        localName.set("庄小焱");
        String mame = localName.get();
        localName.remove();
    }

}
