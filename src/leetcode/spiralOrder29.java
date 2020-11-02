/**
 * Copyright (C), 2018-2020
 * FileName: spiralOrder29
 * Author:   xjl
 * Date:     2020/6/5 8:47
 * Description: 面试题29. 顺时针打印矩阵
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder29 {
    public int[] spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;//行
        if (m == 0) {
            return new int[0];//列
        }
        int n = matrix[0].length;
        //定义四个边
        int x1 = 0;
        int x2 = m - 1;  //3
        int y1 = 0;
        int y2 = n - 1;   //3

        //遍历的次数
        int times = Math.min(m, n) % 2 == 0 ? Math.min(m, n) / 2 : Math.min(m, n) / 2 + 1;

        for (int i = 0; i < times; i++) {
            for (int y = y1; y <= y2; y++) {
                list.add(matrix[x1][y]);
            }
            for (int x = x1 + 1; x <= x2; x++) {
                list.add(matrix[x][y2]);
            }

            if (x1 < x2 && y1 < y2) {
                for (int y = y2 - 1; y > y1; y--) {
                    list.add(matrix[x2][y]);
                }
                for (int x = x2; x > x1; x--) {
                    list.add(matrix[x][y1]);
                }
            }
            x1++;
            x2--;
            y1++;
            y2--;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public List<Integer> prinMartix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList();
        int m = matrix.length;//行
        if (m == 0) {
            return ans;
        }
        int n = matrix[0].length;//列

        int c1 = 0;        // x1
        int c2 = n - 1;    //  x2    3
        int r1 = 0;        // y1
        int r2 = m - 1;    //  y2    3

        //有几圈的问题
        int times = Math.min(m, n) % 2 == 0 ? Math.min(m, n) / 2 : Math.min(m, n) / 2 + 1;

        for (int i = 0; i < times; i++) {
            for (int c = c1; c <= c2; c++) {
                ans.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                ans.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    ans.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    ans.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] matix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //List<Integer> list = prinMartix(matix);

        int[] ints = spiralOrder(matix);
        System.out.println(ints.toString());
    }
}