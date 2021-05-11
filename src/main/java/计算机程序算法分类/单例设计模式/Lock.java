package 计算机程序算法分类.单例设计模式;

/**
 * @Classname Lock
 * @Description TODO
 * @Date 2021/5/10 21:39
 * @Created by xjl
 */
public class Lock {
    /**
     * @description TODO  修饰实例方法，对当前实例对象this加锁
     * @param: null
     * @date: 2021/5/10 21:41
     * @return:
     * @author: xjl
     */
    public class Synchronized1 {
        public synchronized void husband() {

        }
    }

    /**
     * @description TODO 修饰静态方法，对当前类的Class对象加锁
     * @param: null
     * @date: 2021/5/10 21:42
     * @return:
     * @author: xjl
     */
    public class Synchronized2 {
        public void husband() {
            synchronized (Synchronized2.class) {

            }
        }
    }

    /**
     * @description TODO 制定几所对象 给对象加锁
     * @param: null
     * @date: 2021/5/10 21:45
     * @return:
     * @author: xjl
     */
    public class Synchronized3 {
        public void husband() {
            synchronized (new Synchronized3()) {

            }
        }
    }

}
