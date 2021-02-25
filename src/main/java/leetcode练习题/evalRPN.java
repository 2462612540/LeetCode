/**
 * Copyright (C), 2018-2020
 * FileName: evalRPN
 * Author:   xjl
 * Date:     2020/3/31 11:17
 * Description: 根据逆波兰表示法，求表达式的值。
 */
package leetcode练习题;

import org.junit.Test;

import java.util.Stack;

public class evalRPN {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        //利用好stack整个数据结构
        Stack<Integer> stack = new Stack();
        int a, b;
        for (int i = 0; i < tokens.length; i++) {
            //如果是
            switch (tokens[i]) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;
                default:
                    stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.get(0);
    }

    @Test
    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }
}
