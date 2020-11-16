/**
 * Copyright (C), 2018-2020
 * FileName: 双端队列
 * Author:   xjl
 * Date:     2020/11/16 22:52
 * Description:
 */
package 队列问题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列的使用 在很多滑动窗口的方法中的很多时候都是会有用到这这个的一种数据结构
 */
public class 双端队列 {
    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<String>();
        deque.add("d");
        deque.add("e");
        deque.add("f");

        //从队首取出元素，不会删除
        System.out.println("队首取出元素:" + deque.peek());
        System.out.println("队列为:" + deque);

        //从队首加入元素(队列有容量限制时用，无则用addFirst)
        deque.offerFirst("c");
        System.out.println("队首加入元素后为：" + deque);
        //从队尾加入元素(队列有容量限制时用，无则用addLast)
        deque.offerLast("g");
        System.out.println("队尾加入元素后为：" + deque);

        //队尾加入元素
        deque.offer("h");
        System.out.println("队尾加入元素后为：" + deque);

        //TODO 获取并移除队列第一个元素,pollFirst()也是，区别在于队列为空时,removeFirst会抛出NoSuchElementException异常，后者返回null
        deque.removeFirst();
        System.out.println("获取并移除队列第一个元素后为:" + deque);

        //TODO 获取并移除队列第一个元素,此方法与pollLast 唯一区别在于队列为空时,removeLast会抛出NoSuchElementException异常，后者返回null
        deque.removeLast();
        System.out.println("获取并移除队列最后一个元素后为:" + deque);

        //TODO 获取队列第一个元素.此方法与 peekFirst 唯一的不同在于：如果此双端队列为空，它将抛出NoSuchElementException，后者返回null
        System.out.println("获取队列第一个元素为:" + deque.getFirst());
        System.out.println("获取队列第一个元素后为:" + deque);

        //TODO 获取队列最后一个元素.此方法与 peekLast 唯一的不同在于：如果此双端队列为空，它将抛出NoSuchElementException，后者返回null
        System.out.println("获取队列最后一个元素为:" + deque.getLast());
        System.out.println("获取队列第一个元素后为:" + deque);

        //循环获取元素并在队列移除元素
        while (deque.size() > 0) {
            System.out.println("获取元素为：" + deque.pop() + " 并删除");
        }
        System.out.println("队列为:" + deque);
    }

}
