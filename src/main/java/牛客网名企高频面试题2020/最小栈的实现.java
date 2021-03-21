package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.最小栈的实现
 * Author:   xjl
 * Date:     2020/10/1 16:27
 * Description:
 */

import java.util.Stack;

public class 最小栈的实现 {
    Stack<Integer> stack;

    public 最小栈的实现() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.add(x);
            stack.add(x);
        } else {
            //弹出元素
            int n1 = stack.pop();
            int n2 = stack.pop();
            stack.add(n2);
            stack.add(n1);
            //比较当前元素和来的元素
            if (n1 > x) {
                stack.add(x);
                stack.add(x);
            } else {
                stack.add(x);
                stack.add(n1);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int n1 = stack.pop();
        int n2 = stack.peek();
        stack.add(n1);
        return n2;
    }

    public int min() {
        return stack.peek();
    }
}
