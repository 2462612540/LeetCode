package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.栈实现队列
 * Author:   xjl
 * Date:     2020/9/14 12:12
 * Description:
 */

import java.util.Stack;

public class 栈实现队列 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int val) {
        stack1.add(val);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        int val = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
        return val;
    }
}
