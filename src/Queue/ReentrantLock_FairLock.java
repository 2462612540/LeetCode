/**
 * Copyright (C), 2018-2020
 * FileName: ReentrantLock_公平锁
 * Author:   xjl
 * Date:     2020/8/28 8:52
 * Description:
 */
package Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReentrantLock_FairLock implements Lock {

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }

}

/**
 * 自定义的同步器，仅仅实现
 */
class MySync extends AbstractQueuedSynchronizer {
    /**
     * 尝试获取锁
     *
     * @param acquire
     * @return
     */
    @Override
    protected boolean tryAcquire(int acquire) {
        // System.out.println("加锁");
        //1、获取当前的线程
        Thread thread = Thread.currentThread();
        //2、获取当前的线程状态
        int state = getState();
        //3、判断状态是不是为0，如果为0那么就是说明当前锁还未被持有，很有可能有其他线程来获取该锁，那么需要进行CAS操作来设置锁的持有状态
        if (state == 0 && compareAndSetState(0, acquire)) {
            //获取锁成功，将持有线程设置为当前线程
            setExclusiveOwnerThread(thread);
            return true;
            //由于是独占式锁，那么如果是当前线程持有的锁那么就只需要设置状态+1就好了
            //否则就获取不成功
        } else if (thread == getExclusiveOwnerThread()) {
            if (state + acquire >= 0) {
                setState(state + acquire);
            }
            return true;
        }
        return false;
    }

    /**
     * 尝试释放锁
     *
     * @param release
     * @return
     */
    @Override
    protected boolean tryRelease(int release) {
        //释放锁的时候有两点需要注意
        // 1、释放锁的时候肯定是只有持有锁的线程才能来释放锁，所以不需要CAS操作
        //2、释放锁的时候只有当状态为0 的时候才算释放完成
        Thread thread = Thread.currentThread();
        if (thread != getExclusiveOwnerThread()) {
            throw new RuntimeException("非法操作");
        }
        int state = getState() - release;
        boolean flag = false;
        //如果状态为0
        if (state == 0) {
            //将持有线程置空
            setExclusiveOwnerThread(null);
            flag = true;
        }
        //设置线程状态
        setState(state);
        //System.out.println("释放");
        return flag;
    }

    /**
     * 是不是当前线程持有锁
     *
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        return getExclusiveOwnerThread() == Thread.currentThread();
    }

    final ConditionObject newCondition() {
        return new ConditionObject();
    }
}

class SelfLock {

    public static void main(String[] args) {
        final ReentrantLock_FairLock reentrantLock = new ReentrantLock_FairLock();
        final List<Integer> list = new ArrayList<>();
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        final AtomicReference<MyInteger> atomicI = new AtomicReference<MyInteger>(new MyInteger(4999));
        for (int i = 0; i < 5000; i++) {
            list.add(i);
        }
        final MyInteger j = new MyInteger(4999);

        /*keepAliveTile 线程最大空闲时间 */
        ExecutorService executorService =
                new ThreadPoolExecutor(100, 200, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                        while (true) {
                            //   int j = atomicInteger.getAndDecrement();
                            if (j.getIndex() >= 0) {
                                reentrantLock.lock();
                                System.out.println("线程" + Thread.currentThread().getName() + "====》" + list.get(j.getIndex()));
                                j.setIndex(j.getIndex() - 1);
                                reentrantLock.unlock();
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                break;
                            }
                        }
                        countDownLatch.countDown();
                    }
            );
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时---->" + (System.currentTimeMillis() - b));
        executorService.shutdown();

    }

}

class MyInteger {
    int index;

    public MyInteger(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}


