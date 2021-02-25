/**
 * Copyright (C), 2018-2020
 * FileName: MinStack
 * Author:   xjl
 * Date:     2020/4/2 13:12
 * Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 */
package leetcode练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinStack {
    private List<Integer> list;//存储数据的数组
    private int N;//表示的是个数

    public MinStack() {
        this.list = new ArrayList<>();
        this.N = 0;
    }

    public void push(int x) {
        list.add(x);
        N++;
    }

    public void pop() {
        list.remove(N-1);
        N--;
    }

    public int top() {
        return list.get(N-1);
    }

    public int min() {
        return Collections.min(list);
    }

    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
