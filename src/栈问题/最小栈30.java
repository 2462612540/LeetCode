/**
 * Copyright (C), 2018-2020
 * FileName: MinStack30
 * Author:   xjl
 * Date:     2020/8/25 13:11
 * Description: 最小栈
 */
package 栈问题;

import java.util.Stack;

public class 最小栈30 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public 最小栈30() {
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
    }

}
