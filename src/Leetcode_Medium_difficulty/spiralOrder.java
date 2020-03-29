/**
 * Copyright (C), 2018-2020
 * FileName: spiralOrder
 * Author:   xjl
 * Date:     2020/3/28 15:40
 * Description: 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int colums = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {

            }
        }

        return list;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(matrix);
    }
}
