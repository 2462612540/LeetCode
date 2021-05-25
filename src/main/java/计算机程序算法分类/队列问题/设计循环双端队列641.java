package 计算机程序算法分类.队列问题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Classname 设计循环双端队列641
 * @Description TODO
 * @Date 2021/5/25 21:43
 * @Created by xjl
 */
public class 设计循环双端队列641 {

    class MyCircularDeque {
        //利用的两个的栈来实现的 这样的一个的队列
        Deque<Integer> deque = new LinkedList<>();//采用的链表的形式的来决定来判断这样的一个
        LinkedList<Integer> linkedList = new LinkedList<>();

        int max;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            max = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
//            linkedList.addFirst(value);//就是链表的添加和删除的相关问题
//            linkedList.addLast(value);
//            linkedList.removeFirst();
//            linkedList.removeLast();

            if (deque.size() >= max) {
                return false;
            }
            deque.addFirst(value);
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (deque.size() >= max) {
                return false;
            }
            deque.addLast(value);
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (deque.size() == 0) {
                return false;
            }
            deque.removeFirst();
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (deque.size() == 0) {
                return false;
            }
            deque.removeLast();
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (deque.size() == 0) {
                return -1;
            }
            return deque.getFirst();
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (deque.size() == 0) {
                return -1;
            }
            return deque.getLast();
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            if (deque.size() == 0) {
                return true;
            }
            return false;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            if (deque.size() == max) {
                return true;
            }
            return false;
        }
    }
}
