package 计算机程序算法分类.栈问题;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Classname 利用两个队列来实现栈
 * @Description TODO
 * @Date 2021/5/19 14:54
 * @Created by xjl
 */
public class 利用两个队列来实现栈 {

    Queue<Integer> queue1;//存取的元素的
    Queue<Integer> queue2;//临时存放元素

    public 利用两个队列来实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    /**
     * @description TODO 入栈的
     * @param: x
     * @date: 2021/5/19 19:20
     * @return: void
     * @author: xjl
    */
    public void push(int x) {
        //检查是否无空
        while (!queue1.isEmpty()) {
            queue2.add(queue1.peek());
            queue1.poll();
        }
        //刚进来的元素
        queue1.add(x);
        while (!queue2.isEmpty()) {
            queue1.add(queue2.peek());
            queue2.poll();
        }
    }
    /**
     * @description TODO  出栈
      * @param:
     * @date: 2021/5/19 19:20
     * @return: int
     * @author: xjl
    */
    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);

        while (!queue.isEmpty()) {
            System.out.println();
        }
    }

}
