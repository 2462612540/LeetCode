/**
 * Copyright (C), 2018-2020
 * FileName: MinStack30II
 * Author:   xjl
 * Date:     2020/8/25 13:44
 * Description: 栈
 */
package Stack;

import java.util.Stack;

public class MinStack30II {

    Stack<Integer> A, B;

    public MinStack30II() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {
        MinStack30II stack = new MinStack30II();
        stack.push(-3);
        stack.push(0);
        stack.push(-2);

        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.min());
    }
}
