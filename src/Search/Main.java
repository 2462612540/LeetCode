/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/9 8:36
 * Description: 查找问题集合
 */
package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       sc4();
    }

    public static void sc4() {
        //输入的数字
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //调用函数
        int i = test4(array);
        //输入结果
        System.out.println(i);

    }

    private static int test4(int[] array) {
        if (array.length==1){
            return 0;
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < array[i - 1] && array[i] < array[i + 1]) {
                return array[i];
            }
        }
        return 0;
    }

    public static void sc3() {
        //输入的数字
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();
        //简历一个二维数组
        int[][] martix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                martix[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        //调用函数
        String result = test3(martix, K);
        //输出结果
        System.out.println(result);
    }

    public static String sc31() {
        //输入的数字
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                list.add(sc.nextInt());
            }
            sc.nextLine();
        }
        //调用函数
        if (list.contains(K)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void sc1() {
        //输入的数字
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        //点翻译数组
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }

        //调用函数
        int result = test2(array);
        //输出结果
        System.out.println(result);
    }

    //只能通过95%的
    private static int test(int[] array) {
        int length = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }
            if (count > length) {
                return array[i];
            }
        }
        return -1;
    }

    //100%的用例的通过测试
    private static int test2(int[] array) {
        int length = array.length / 2;
        Arrays.sort(array);
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                count++;
                if (count > length) {
                    return array[i];
                }
            } else {
                count = 1;
            }
        }
        return -1;
    }

    private static String test3(int[][] martix, int k) {
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length; j++) {
                if (martix[i][j] == k) {
                    return "Yes";
                }
            }
        }
        return "No";
    }
}
