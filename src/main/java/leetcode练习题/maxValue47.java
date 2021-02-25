/**
 * Copyright (C), 2018-2020
 * FileName: maxValue47
 * Author:   xjl
 * Date:     2020/6/2 14:33
 * Description: 面试题47. 礼物的最大价值
 */
package leetcode练习题;

import org.junit.Test;

/**
 * 典型的动态规划问题及时最大值
 */
public class maxValue47 {
    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < row; ++i)
            grid[i][0] += grid[i - 1][0];

        for (int j = 1; j < col; ++j)
            grid[0][j] += grid[0][j - 1];

        for (int i = 1; i < row; ++i)
            for (int j = 1; j < col; ++j) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        return grid[row - 1][col - 1];
    }

    @Test
    public void test() {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int count = maxValue(array);
        System.out.println(count);
    }
}
