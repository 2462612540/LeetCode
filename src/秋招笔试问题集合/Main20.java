/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class Main20 {

    /**
     * 已知这个4行
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入的数量
        int m = sc.nextInt();//A
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        //存放结果
        for (int i = 0; i < m; i++) {
            list.add(sc.nextLine());
        }
        //处理
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            //超过10
            if (s.length() > 10) {
                continue;
            }
            //查询是否字符
            int flag = 0;
            //遍历
            for (int j = 0; j < s.length(); j++) {
                if ((s.charAt(j) <= 'z' && s.charAt(j) >= 'a') || (s.charAt(j) <= 'Z' && s.charAt(j) >= 'A')) {
                    continue;
                } else {
                    //表示不是符合的
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                flag = 0;
            } else {
                result++;
            }
        }
        System.out.println(result);
    }
}

