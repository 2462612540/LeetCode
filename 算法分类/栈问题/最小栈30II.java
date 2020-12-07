/**
 * Copyright (C), 2018-2020
 * FileName: MinStack30II
 * Author:   xjl
 * Date:     2020/8/25 13:44
 * Description: 栈
 */
package 栈问题;

import java.util.Stack;

public class 最小栈30II {

    Stack<Integer> A, B;

    public 最小栈30II() {
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

}
