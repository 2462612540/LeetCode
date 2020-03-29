/**
 * Copyright (C), 2018-2020
 * FileName: isValid
 * Author:   xjl
 * Date:     2020/2/29 15:01
 * Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

import java.util.*;

public class isValid {

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.add(c);
            } else {
                if (stack.size() == 0 || map.get(c) != stack.pop()) {
                    return false;
                }

            }
        }
        return stack.size() == 0;
    }

    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                //添加到栈内
                stack.add(s.charAt(i));
            } else {
                if (stack.size() != 0 && (map.get(s.charAt(i)) == stack.peek())) {
                    stack.pop();//这就是删除栈顶的元素
                } else {
                    //如果不等于栈顶的元素那就返回flase
                    return false;
                }
            }
        }
        //查看是否栈内为空 如果是空的便是全部匹配，如果是不为空的那么久表示还有单独的剩下的符号
        return stack.size() == 0;
    }

    @Test
    public void test() {
        System.out.println(isValid2("]"));
        ThreadLocal<Integer> number = new ThreadLocal();
        number.get();
        number.set(2);
    }

}
