/**
 * Copyright (C), 2018-2020
 * FileName: IO_template
 * Author:   xjl
 * Date:     2020/6/7 21:09
 * Description: 输入输出的测试用例
 */
package IO_Template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 平时写程序一般不用Scanner，线上笔试的时候，各大公司热衷于Scanner输入。
 * 平时用LeetCode刷题也不会用到，结果多次在笔试时候卡在Scanner，特来总结一波。
 */
public class IO_template {

    public static void main(String[] args) {
    }

    /**
     * 多行输入元素，其中第一行几个数字表示下面几行的个数。
     * // 输入如下
     * 输入的数据分别表示的是的数组的大小
     * 3 4
     * 10 2 3
     * 11 4 5 6
     */
    public static void test1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] num1 = new int[m];
            int[] num2 = new int[n];
            for (int i = 0; i < m; i++) {
                num1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                num2[i] = sc.nextInt();
            }

            //显示结果的代码
            System.out.println("输出：");
            System.out.println(Arrays.toString(num1));
            System.out.println(Arrays.toString(num2));
        }
    }

    /**
     * 在一行输入多个参数
     * ABB CCC DDD  EEE 123 435
     */
    public static void test2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();  // 读取一行
            String[] strIn = str.trim().split(" ");  // 以空格分割
            System.out.println(Arrays.toString(strIn));//显示结果
        }
    }

    /**
     * 每行输入不等数量的参数  存储的是的数字
     * <p>
     * 3
     * AA bcd 123 54
     * AA BB
     * A B C
     */
    public static void test3() {
        Scanner sc = new Scanner(System.in);
        //一共几行
        int m = sc.nextInt();
        sc.nextLine();  // 很重要，跳到第二行
        //存放数据的list中的
        ArrayList<int[]> list = new ArrayList<>();

        String[] strArr = new String[m];
        // 从第二行开始读取  存储是整形数组
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split(" ");
            //新建立的数组
            int[] array = new int[s.length];
            //新数组赋值
            for (int j = 0; j < array.length; j++) {
                array[j] = Integer.valueOf(s[j]);
            }
            list.add(array);
        }
        //显示结果
        for (int[] s : list) {
            for (int v : s) {
                System.out.print(v + "--");
            }
            System.out.println();
        }
    }

    /**
     * 第一行是是表示的数据的行数 第二是表示的每一行的数据
     * 3
     * 5 6 4
     * 5 69 87 78
     * 8 9 7 2
     */
    public static void test4() {
        Scanner sc = new Scanner(System.in);
        //读取几行停止输入
        int m = sc.nextInt() - 1;
        //读取下一行
        sc.nextLine();
        List<String[]> list = new ArrayList<>();

        while (sc.hasNext()) {
            //String str = sc.nextLine();
            String[] s = sc.nextLine().split(" ");
            list.add(s);
            if (m > 0) {
                --m;
            } else {
                break;
            }
        }
        for (String[] s : list) {
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i] + " ");
            }
            System.out.println();
        }
    }

    /**
     * java中从控制台输入多行数据 按回车键输入空行结束
     * 4
     * 5
     * 6
     * 空格
     */
    public static void test5() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        do {
            //读取到的每一行的字符串
            String string = sc.nextLine();
            if (string.equals("")) {
                break;
            }
            list.add(Integer.valueOf(string));
        } while (true);
        //显示结果
        for (int v : list) {
            System.out.println(v);
        }
    }

    /**
     * 每行输入不等数量的参数 下面每一行都是存储的是的字符串
     * <p>
     * 3
     * AA bcd 123 54
     * AA BB
     * A B C
     */
    public static void test6() {
        Scanner sc = new Scanner(System.in);
        //一共几行
        int m = sc.nextInt();
        sc.nextLine();  // 很重要，跳到第二行
        //字符串数组
        ArrayList<String[]> list2 = new ArrayList<>();
        // 从第二行开始读取  存取的是的String类型的数组
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split(" ");
            list2.add(s);
        }
        //显示结果
        for (String[] ss : list2) {
            for (String s : ss) {
                System.out.print(s + "--");
            }
            System.out.println();
        }
    }

}
