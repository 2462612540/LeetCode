/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package Test_Pricate;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //数据的输入
        Scanner cs = new Scanner(System.in);
        String str = cs.nextLine().replace("\t", " ");
        String[] s = str.split(" ");
        if (s.length == 0) {
            System.out.println(" ");
        }
        //存放结果的
        Stack<String> stack1 = new Stack<>();
        //存放删除的
        Stack<String> stack2 = new Stack<>();
        String result = "";
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("")) {
                continue;
            }
            if (s[i].equals("undo")) {
                if (!stack1.isEmpty()) {
                    stack2.add(stack1.peek());
                    stack1.pop();
                    continue;
                }
            } else if (s[i].equals("redo")) {
                if (!stack2.isEmpty()) {
                    stack1.add(stack2.peek());
                    stack2.pop();
                    continue;
                }
            } else {
                stack1.add(s[i]);
            }
        }
        for (String ss : stack1) {
            result += ss + " ";
        }
        System.out.println(result.trim());
    }
}

