/**
 * Copyright (C), 2018-2020
 * FileName: validateStackSequences
 * Author:   xjl
 * Date:     2020/4/5 8:44
 * Description: 栈的压入、弹出序列
 */
package leetcode练习题;

import org.junit.Test;

import java.util.Stack;

public class validateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int i = 0, len = pushed.length; i < len; i++) {
            stack.push(pushed[i]);
            //表示的是里面表示的是当前如果是当前的元素是第一个元素那么弹出栈，如果不是的话那就是添加入栈，
            while (!stack.isEmpty() && index < len && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        //一直到判断的stack中是否为空？
        return stack.isEmpty();
    }

    @Test
    public void test() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 5, 3, 2, 1};
        validateStackSequences(pushed, poped);
    }

}
