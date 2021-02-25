package 牛客网名企高频面试题; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.有效括号
 * Author:   xjl
 * Date:     2020/9/14 12:57
 * Description:
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效括号 {

    @Test
    public void test() {
        boolean valid = isValid("[][");
        System.out.println(valid);
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put(')', '(');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(') {
                stack.add(s.charAt(i));
            } else {
                if (stack.size() != 0 && (map.get(s.charAt(i)) == stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    public boolean isValid2(String s) {
        // write code here
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chr.length; i++) {
            if (!map.containsKey(chr[i])) {
                stack.push(chr[i]);
            } else {
                if (stack.isEmpty() || map.get(chr[i]) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chr.length; i++) {
            if (!map.containsKey(chr[i])) {
                stack.push(chr[i]);
            } else {
                if (stack.isEmpty() || map.get(chr[i]) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
