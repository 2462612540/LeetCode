/**
 * Copyright (C), 2018-2020
 * FileName: setZeroes0108
 * Author:   xjl
 * Date:     2020/6/10 14:42
 * Description: 面试题 01.08. 零矩阵
 */
package leetcode练习题;

import org.junit.Test;

public class setZeroes0108 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;//行数3
        int m = matrix[0].length;//列数4
        //设置是否被访问
        boolean[][] viist = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //若果是0且没有被访问过
                if (matrix[i][j] == 0 && !viist[i][j]) {
                    //将行改为0 并将表示改了
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = 0;
                            viist[i][k] = true;
                        }
                    }
                    //将列改为0 并将表示改了
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] != 0) {
                            matrix[k][j] = 0;
                            viist[k][j] = true;
                        }
                    }
                }
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
    }
}
