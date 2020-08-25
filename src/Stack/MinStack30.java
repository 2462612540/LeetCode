/**
 * Copyright (C), 2018-2020
 * FileName: MinStack30
 * Author:   xjl
 * Date:     2020/8/25 13:11
 * Description: 最小栈
 */
package Stack;

import java.util.Stack;

public class MinStack30 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack30() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.add(x);
        } else {
            //比较当前元素和stack的顶不元素
            while (!stack1.isEmpty() && x >= stack1.peek()) {
                stack2.add(stack1.peek());
                stack1.pop();
            }
            //加入
            stack1.add(x);
            //将原来的元素拿回来
            while (!stack2.isEmpty()) {
                stack1.add(stack2.peek());
                stack2.pop();
            }
        }
    }

    public void pop() {
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack1.peek();
    }

    public boolean Empty() {
        return stack1.size() == 0;
    }

    public static void main(String[] args) {
        MinStack30 stack = new MinStack30();
        stack.push(-3);
        stack.push(0);
        stack.push(-2);

        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }


}
