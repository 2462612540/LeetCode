/**
 * Copyright (C), 2018-2020
 * FileName: twonumber_big_sum
 * Author:   xjl
 * Date:     2020/7/4 14:55
 * Description: 测试案例
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        //int test = test();
        // System.out.println(test);

        //---------------------
        test2();
    }

    public static int test() {
        Scanner sc = new Scanner(System.in);
        //输入的第一行
        int n = sc.nextInt();
        sc.nextLine();
        int result = 1;
        ArrayList<Integer> list = new ArrayList<>();
        //存放数据
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            list.add(num);
        }
        //寻找结果
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入
            String str = sc.nextLine();
            //处理
            boolean result = ishiuwen(str);
            //输出
            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean ishiuwen(String str) {
        int length = str.length();
        String result = str + str;
        for (int i = 0; i < length; i++) {
            String s = result.substring(i, i + length);
            if (ishiu(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean ishiu(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    List<List<Integer>> lists = new ArrayList<>();
    Boolean[] used;

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            //输入的数据
            int m = sc.nextInt();
            //如果是的小于10那么是没有扎到
            if (m < 10) {
                System.out.println("Not Found");
            } else {
                //如果是大于10 将数字存储到了list中
                while (m != 0) {
                    list.add(m % 10);
                    m = m % 10;
                }
                List<Integer> list1 = help(list);
                Collections.sort(list1);

            }
        }
    }

    private static List<Integer> help(ArrayList<Integer> list) {
        //转为数组
        int[] array = new int[list.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return null;
    }

}
