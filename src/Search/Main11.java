/**
 * Copyright (C), 2018-2020
 * FileName: Main11
 * Author:   xjl
 * Date:     2020/7/12 13:06
 * Description: 测试的工作
 */
package Search;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main11 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            stack.add(sc.nextInt());
        }
        //调用
        Collections.sort(stack, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        //输出
        for (int V : stack) {
            System.out.println(V);
        }
    }
}
