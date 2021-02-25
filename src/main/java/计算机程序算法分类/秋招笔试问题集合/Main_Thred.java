/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread {
    private int num = 1;
    private int isprint = 1;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public MyThread() {
        super();
    }

    final Lock lock = new ReentrantLock();
    final Condition one = lock.newCondition();
    final Condition two = lock.newCondition();
    final Condition three = lock.newCondition();

    public void funone() {
        lock.lock();
        try {
            while (isprint != 1) {
                try {
                    one.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            print();
            isprint = 2;
            two.signal();
        } finally {
            lock.unlock();
        }
    }

    public void funtwo() {
        lock.lock();
        try {
            while (isprint != 2) {
                try {
                    two.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            print();
            isprint = 3;
            three.signal();
        } finally {
            lock.unlock();
        }
    }

    public void funthree() {
        lock.lock();
        try {
            while (isprint != 3) {
                try {
                    three.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            print();
            isprint = 1;
            one.signal();
        } finally {
            lock.unlock();
        }
    }

    private void print() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + num++);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main_Thred {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (myThread.getNum() <= 65) {
                    myThread.funone();
                }
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (myThread.getNum() <= 70) {
                    myThread.funtwo();
                }
            }
        }, "thread2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (myThread.getNum() <= 75) {
                    myThread.funthree();
                }
            }
        }, "thread3").start();
    }
}
