package 牛客网名企面试笔试代码复现2021;

/**
 * @Classname Sigleton
 * @Description TODO
 * @Date 2021/3/21 9:11
 * @Created by xjl
 */
public class Sigleton {

}

/**
 * @description TODO  饿汉模式
 * @param: null
 * @date: 2021/3/21 9:12
 * @return:
 * @author: xjl
 */
class Sigleton1 {
    private Sigleton1 sigleton1 = new Sigleton1();

    private Sigleton1() {
    }

    //获取这个实例的对象
    private Sigleton1 Sigleton1() {
        return sigleton1;
    }
}

/**
 * @description TODO  这里采用的双重锁的模式
 * @param: null
 * @date: 2021/3/21 9:16
 * @return:
 * @author: xjl
 */
class Sigleton2 {
    private volatile Sigleton2 sigleton2;

    private Sigleton2() {
    }

    private Sigleton2 getSigleton2() {
        if (sigleton2 == null) {
            synchronized (Sigleton2.class) {
                if (sigleton2 == null) {
                    sigleton2 = new Sigleton2();
                }
            }
        }
        return sigleton2;
    }
}

class Sigleton3 {
    //这里使用了的饿汉的模式
    class Sigleton3hander {
        private Sigleton3 sigleton3 = new Sigleton3();

        private Sigleton3 getSigleton3() {
            return sigleton3;
        }
    }

    public Sigleton3() {
    }

    //获取对象的实例
    public Sigleton3 sigleton3() {
        return new Sigleton3hander().getSigleton3();
    }
}

/**
 * @description TODO  使用的是重型锁
 * @param: null
 * @date: 2021/3/21 9:25
 * @return:
 * @author: xjl
 */
class Sigleton4 {
    private Sigleton4 sigleton4;

    public synchronized Sigleton4 getSigleton4() {
        if (sigleton4 == null) {
            sigleton4 = new Sigleton4();
        }
        return sigleton4;
    }
}

/**
 * @description TODO  这里也是使用了锁的一种机制
 * @param: null
 * @date: 2021/3/21 9:27
 * @return:
 * @author: xjl
 */
class Sigleton5 {
    private Sigleton5 sigleton5;

    public Sigleton5 getSigleton5() {
        if (sigleton5 == null) {
            synchronized (Sigleton5.class) {
                if (sigleton5 == null) {
                    sigleton5 = new Sigleton5();
                }
            }
        }
        return sigleton5;
    }
}



