/**
 * Copyright (C), 2018-2020
 * FileName: 旋转矩阵
 * Author:   xjl
 * Date:     2020/9/4 19:23
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.List;

public class 旋转矩阵 {

    public int[] SpiralMatrix(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int rows = matrix.length;
        int colums = matrix[0].length;
        boolean[][] visited = new boolean[rows][colums];
        int total = rows * colums;
        int row = 0, colum = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][colum]);
            visited[row][colum] = true;
            int nextRow = row + directions[index][0], nexColum = colum + directions[index][1];
            if (nextRow < 0 || nextRow >= rows || nexColum < 0 || nexColum >= colums || visited[nextRow][nexColum]) {
                index = (index + 1) % 4;
            }
            row += directions[index][0];
            colum += directions[index][1];
        }
        int[] ans = new int[order.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = order.get(i);
        }
        return ans;
    }
}
