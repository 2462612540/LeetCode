/**
 * Copyright (C), 2018-2020
 * FileName: Sigleton
 * Author:   xjl
 * Date:     2020/10/12 9:13
 * Description:
 */
package 计算机程序算法分类.单例设计模式;

/**
 * 这是测试的新的单例模式的编写
 */
public class Sigleton {

}

/**
 * 饿汉模式的
 */
class Singleton01 {
    private Singleton01 singleton01 = new Singleton01();

    public Singleton01() {
    }

    public Singleton01 getSingleton01() {
        return singleton01;
    }
}

/**
 * 懒汉模式的
 */
class Singleton02 {
    private Singleton02 singleton02;

    public Singleton02() {
    }

    public synchronized Singleton02 getSingleton02() {
        if (singleton02 == null) {
            singleton02 = new Singleton02();
        }
        return singleton02;
    }
}

/**
 * 双重锁模式的
 */
class Singleton03 {
    private volatile Singleton03 singleton03;

    public Singleton03() {
    }

    public Singleton03 getSingleton03() {
        if (singleton03 == null) {
            synchronized (Singleton03.class) {
                if (singleton03 == null) {
                    singleton03 = new Singleton03();
                }
            }
        }
        return singleton03;
    }
}

/**
 * 内部静态类
 */
class Singleton04 {
    public Singleton04() {

    }

    public Singleton04 getInstane() {
        return new Singleton04Hander().getSingleton04();
    }

    class Singleton04Hander {
        private Singleton04 singleton04 = new Singleton04();

        public Singleton04 getSingleton04() {
            return singleton04;
        }
    }

}
