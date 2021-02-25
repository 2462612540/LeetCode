/**
 * Copyright (C), 2018-2020
 * FileName: spiralOrder
 * Author:   xjl
 * Date:     2020/4/4 12:18
 * Description: 顺时针打印矩阵
 */
package 牛客网练习题;

import org.junit.Test;

public class spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; // left to right.
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; // top to bottom.
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; // right to left.
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; // bottom to top.
            if (++l > r) break;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] mart = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int va : spiralOrder(mart)) {
            System.out.print(va);
        }

    }
}
