/**
 * Copyright (C), 2018-2020
 * FileName: MyStack
 * Author:   xjl
 * Date:     2020/8/25 12:59
 * Description: 队列实现栈
 */
package 栈问题;

import java.util.LinkedList;
import java.util.Queue;

public class 队列实现栈 {

    Queue<Integer> queue1;//存取的元素的
    Queue<Integer> queue2;//临时存放元素

    public 队列实现栈() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

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
        队列实现栈 stack = new 队列实现栈();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.empty()) {
            System.out.println(stack.top());
            stack.pop();
        }
    }

}
