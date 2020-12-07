/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int[] array1 = new int[4];
        int[] array2 = new int[4];
        for (int i = 0; i < 4; i++) {
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            array2[i] = sc.nextInt();
        }
        int result = isrecture(array1, array2);
        System.out.println(result);
    }

    private static int isrecture(int[] rec1, int[] rec2) {
        if (!(rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3])) {
            return 1;
        } else {
            return 0;
        }
    }
}
