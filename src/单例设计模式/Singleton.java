/**
 * Copyright (C), 2018-2020
 * FileName: Singleton
 * Author:   xjl
 * Date:     2020/10/11 9:10
 * Description:
 */
package 单例设计模式;

/**
 * 属于的是饿汉模式
 */
public class Singleton {

    private Singleton singleton = new Singleton();

    private Singleton() {
    }

    private Singleton getSingleton() {
        return singleton;
    }
}

/**
 * 这是赖汉式的方法
 */
class Singleton1 {
    private Singleton1 singleton1;

    private Singleton1() {
    }

    public synchronized Singleton1 getsingleton1() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

/**
 * 使用的是的双重锁机制
 */
class Singleton2 {
    private volatile Singleton2 singleton2;

    private Singleton2() {
    }

    public Singleton2 getSingleton2() {
        if (singleton2 == null) {
            synchronized (Singleton2.class) {
                if (singleton2 == null) {
                    singleton2 = new Singleton2();
                    return singleton2;
                }
            }
        }
        return singleton2;
    }
}

/**
 * 使用的内部静态方法
 */
class Singleton3 {
    /**
     * 空构造函数
     */
    private Singleton3() {
    }

    /**
     * 获取的对象
     *
     * @return
     */
    private static Singleton3 getInstance() {
        return SingletonHolder.Instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton3 Instance = new Singleton3();
    }
}
