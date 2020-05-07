/**
 * Copyright (C), 2018-2020
 * FileName: test1
 * Author:   xjl
 * Date:     2020/4/22 10:45
 * Description: 测试Io的交集
 */
package CodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * java总的各种的输入的模板
 */
public class Main {

    public static void main(String args[]) {
//        Input1();
        Input2();
    }

    /**
     * 输入的一个行表示的总的行数
     * 每一个行的第一个数字为
     * 3
     * 4 1 1 1 1
     * 5 1 1 1 1 2
     * 6 1 1 2 5 4 6
     */
    public static void Input2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            for (int i = 0; i < number; i++) {
                List<Integer> list = new ArrayList<>();
                list.add(sc.nextInt());
                System.out.println(list.size());
            }
        }

    }

    /**
     * 输入的是两个数组数据和两个数组 存储不一定是要的是数组 或者是可以使用的是 ArrayaList的动态数组来实现
     */
    public static void Input1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入数据
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] number1 = new int[m];
            int[] number2 = new int[n];
            //存入两个数组
            for (int i = 0; i < m; i++) {
                number1[i] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                number2[j] = sc.nextInt();
            }

            System.out.println("第一个数组为：***************************");
            for (int value : number1) {
                System.out.println(value);
            }

            System.out.println("第二个数组为：***************************");
            for (int value : number2) {
                System.out.println(value);
            }
        }
        sc.close();
    }
}


