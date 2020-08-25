/**
 * Copyright (C), 2018-2020
 * FileName: MyQueue
 * Author:   xjl
 * Date:     2020/8/25 12:43
 * Description: 栈实现队列
 */
package Stack;

import java.util.Stack;

/**
 * 利用的两个栈来实现的队列的
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //插入元素
    public void push(int x) {
        //现将stack中弹出
        while (!stack1.isEmpty()) {
            stack2.add(stack1.peek());
            stack1.pop();
        }
        //插入元素
        stack1.add(x);
        //在往stack1中
        while (!stack2.isEmpty()) {
            stack1.add(stack2.peek());
            stack2.pop();
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);

        while (!queue.empty()) {
            System.out.println(queue.peek());
            queue.pop();
        }
    }
}


