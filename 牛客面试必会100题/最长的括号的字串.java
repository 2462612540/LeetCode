/**
 * Copyright (C), 2018-2020
 * FileName: 最长的括号的字串
 * Author:   xjl
 * Date:     2020/9/24 11:35
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 这个就是有效括号
 */
public class 最长的括号的字串 {
    public int longestValidParentheses(String s) {
        //存入基本的map
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && map.get(s.charAt(i)) == stack.peek()) {
                    count++;
                    stack.pop();
                }
            }
        }
        return count * 2;
    }

    @Test
    public void test() {
        String s = "))())())()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}
