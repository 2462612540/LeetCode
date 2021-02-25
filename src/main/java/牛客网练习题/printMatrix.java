/**
 * Copyright (C), 2018-2020
 * FileName: printMatrix
 * Author:   xjl
 * Date:     2020/5/9 8:25
 * Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class printMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        //获取行列
        int m = matrix.length;
        int n = matrix[0].length;
        Boolean[][] flags = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flags[i][j] = false;
            }
        }
        //开始移动的方向
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        ArrayList<Integer> list = new ArrayList<>();
        //开始访问
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[r][c]);
            flags[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < m && 0 <= cc && cc < n && !flags[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return list;
    }

    @Test
    public void test() {
        int m = 4;
        int n = 4;
        Boolean[][] flags = new Boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(flags[i][j]);
            }
        }
    }

    @Test
    public void test2() {
        int[][] martix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List list = printMatrix(martix);
        System.out.println(list.toString());
    }
}
