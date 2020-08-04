/**
 * Copyright (C), 2018-2020
 * FileName: balancedStringSplit1221
 * Author:   xjl
 * Date:     2020/8/3 9:51
 * Description: 1221. 分割平衡字符串
 */
package Greedy_problem;

import java.util.Stack;

public class balancedStringSplit1221 {
    public int balancedStringSplit(String s) {
        //利用一个变量num记录'L'('R')的数量，遍历字符串s，如果字符为'L'('R')，则num++，否则num--
        int num = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                num++;
            } else {
                num--;
            }
            if (num == 0)
                res++;
        }
        return res;
    }

    /**
     * 使用一个栈来实现该功能：
     * 1)当栈中没有元素时，当前字符入栈;
     * 2)当栈中有元素时，若栈顶字符与当前字符一致，字符入栈，否则栈顶出栈；
     * 3)检查当前栈是否为空，若为空则平衡次数+1；
     *
     * @param s
     * @return
     */
    public int balancedStringSplit1(String s) {
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.isEmpty() || c == stack.peek()) {
                stack.push(c);
            }
            else{
                stack.pop();
            }
            if(stack.isEmpty()) {
                count++;
            }
        }
        return count;
    }

}
