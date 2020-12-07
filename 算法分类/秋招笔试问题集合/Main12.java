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

public class Main12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        //函数的调用
        ArrayList<Integer> list = test001(array, K, N);

        //输出旗子的位置 和回退多少 空格隔开
        if (list.size() == 0) {
            System.out.print("paradox");
        } else {
            for (int V : list) {
                System.out.print(V + " ");
            }
        }
    }

    private static ArrayList test001(int[] array, int K, int n) {
        //存放结果
        ArrayList<Integer> list = new ArrayList<>();
        int cout = 0;

        for (int i = 0; i < array.length; i++) {
            if ((K - array[i]) > 0) {
                K=K-array[i];
            }else {

            }
        }
        list.add(Math.abs(K));
        list.add(cout);
        return list;
    }
}
