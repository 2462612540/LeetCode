/**
 * Copyright (C), 2018-2020
 * FileName: IsPopOrder
 * Author:   xjl
 * Date:     2020/5/10 9:52
 * Description: 栈的压入和弹出的序列
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.Stack;

public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        st.push(pushA[i++]);
        while (j <= popA.length - 1) {
            while (popA[j] != st.peek()) {
                if (i == pushA.length) return false;
                st.push(pushA[i++]);
            }
            j++;
            st.pop();
        }
        return true;
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 3, 5, 1, 2};

        System.out.println(IsPopOrder(a, b));
    }
}
