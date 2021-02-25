/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class 拼多多 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[][] grid = new int[m][m];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    grid[j][k] = sc.nextInt();
                }
            }
            int res = test11(grid, m);
            list.add(res);
        }
        for (int i : list) {
            System.out.println(i);
        }
    }

    private static int test11(int[][] pic, int m) {
        int len = pic.length;
        int mul = m / 10;
        if (pic[mul][2 * mul] == 1 && pic[mul][3 * mul] == 1 && pic[mul][4 * mul] == 1 && pic[mul][5 * mul] == 1 && pic[mul][6 * mul] == 1 && pic[mul][7 * mul] == 1) {
            return 7;
        } else if (pic[mul][3 * mul] == 1 && pic[mul][4 * mul] == 1 && pic[mul][5 * mul] == 1 && pic[mul][6 * mul] == 1) {
            if (pic[2 * mul][2 * mul] == 1 && pic[2 * mul][3 * mul] == 1 && pic[2 * mul][4 * mul] == 1 && pic[2 * mul][5 * mul] == 1 && pic[2 * mul][6 * mul] == 1 && pic[2 * mul][7 * mul] == 1) {
                return 2;
            } else if (pic[2 * mul][2 * mul] == 1 && pic[2 * mul][3 * mul] == 1 && pic[2 * mul][6 * mul] == 1 && pic[2 * mul][7 * mul] == 1) {
                if (pic[3 * mul][2 * mul] == 1 && pic[3 * mul][3 * mul] == 1 && pic[3 * mul][6 * mul] == 1 && pic[3 * mul][7 * mul] == 1) {
                    if (pic[4 * mul][2 * mul] == 1 && pic[4 * mul][3 * mul] == 1 && pic[4 * mul][6 * mul] == 1 && pic[4 * mul][7 * mul] == 1) {
                        return 0;
                    } else if (pic[4 * mul][3 * mul] == 1 && pic[4 * mul][4 * mul] == 1 && pic[4 * mul][5 * mul] == 1 && pic[4 * mul][6 * mul] == 1 && pic[4 * mul][7 * mul] == 1) {
                        return 9;
                    } else {
                        return 8;
                    }
                } else {
                    return 3;
                }
            } else {
                return 6;
            }
        } else if (pic[mul][4 * mul] == 1 && pic[mul][5 * mul] == 1) {
            if (pic[3 * mul][2 * mul] == 1 && pic[3 * mul][3 * mul] == 1 && pic[3 * mul][4 * mul] == 1 && pic[3 * mul][5 * mul] == 1) {
                return 4;
            } else {
                return 1;
            }
        } else {
            return 5;
        }
    }
}
