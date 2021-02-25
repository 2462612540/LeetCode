/**
 * Copyright (C), 2018-2020
 * FileName: AQS
 * Author:   xjl
 * Date:     2020/8/28 8:27
 * Description: 阻塞队列的实现
 */
package 计算机程序算法分类.队列问题;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS 实现的阻塞队列的实现就是 分为两个部分在进入队列的时候也是需要对锁进行的资源的获取
 *     在获取线程的时候的时候也是需要时对锁资源获取才能拿到线程的对象 这是的实现了公平锁
 * @param <E>
 */
public class AQS阻塞队列<E> {

    private final int capacity;

    private Lock lock = new ReentrantLock();
    //判断是否满了
    private Condition unfull = lock.newCondition();
    //判断时候为空
    private Condition unEmpty = lock.newCondition();

    private int count;
    //用于存放的队列
    private LinkedList<E> queue;

    /**
     * 对capacity实现的初始化
     * @throws InterruptedException
     */
    public AQS阻塞队列() throws InterruptedException {
        this(Integer.MAX_VALUE);
    }

    /**
     * 实现的队里的初始化的操作
     * @param capacity
     * @throws InterruptedException
     */
    public AQS阻塞队列(int capacity) throws InterruptedException {
        this.capacity = capacity;
        queue = new LinkedList<E>();
    }

    /**
     * 线程阻塞队列
     *
     * @param e
     * @throws InterruptedException
     */
    public void put(E e) throws InterruptedException {
        //获取锁
        lock.lock();
        try {
            //阻塞队列已满，等待线程对象进入睡眠
            while (count == capacity) {
                unfull.await();
            }
            //否则进入队列 然后在添加到阻塞队列中
            queue.add(e);
            //队列个数+1
            count++;
            //通知等待线程进行锁的抢夺
            unfull.signal();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    /**
     * 获取队列的线程
     *
     * @return
     * @throws InterruptedException
     */
    public E take() throws InterruptedException {
        //获取锁资源
        lock.lock();
        try {
            //队列为空，阻塞  并进行等待
            while (count == 0) {
                unEmpty.await();
            }
            //获得所资源的 拿到队列中的线程对象
            E e = queue.pop();
            //队列个数-1
            count--;
            //通知的等待线程获取队列中的对象
            unEmpty.signal();
            //并返回这个对象
            return e;
        } finally {
            //释放锁资源
            lock.unlock();
        }
    }

}
