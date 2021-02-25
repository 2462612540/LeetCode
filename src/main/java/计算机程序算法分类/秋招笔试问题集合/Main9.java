/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int[] money = {1, 5, 10, 50, 100};
        int[] moneynum = new int[5];
        for (int i = 0; i < 5; i++) {
            moneynum[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int count = 0;
        //函数的调用
        for (int i = money.length - 1; i >= 0; i--) {
            while (k >= money[i] && moneynum[i] > 0) {
                k -= money[i];
                moneynum[i] -= 1;
                count += 1;
            }
        }
        if (count==0){
            System.out.println(-1);
        }else {
            //结果的打印
            System.out.println(count);
        }
    }
}
