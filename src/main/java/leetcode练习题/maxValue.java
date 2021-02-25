/**
 * Copyright (C), 2018-2020
 * FileName: maxValue47
 * Author:   xjl
 * Date:     2020/4/3 12:43
 * Description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import org.junit.Test;

public class maxValue {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0, j = 0;
        int sum = grid[0][0];
        while (i==(m-1) || j < n) {
            if (i == m) {
                sum += grid[i][j + 1];
                j++;
                continue;
            }
            if (j == n) {
                sum += grid[i + 1][j];
                i++;
                continue;
            }

            if (grid[i + 1][j] >= grid[i][j + 1]) {
                sum += grid[i + 1][j];
                i++;
            } else {
                sum += grid[i][j + 1];
                j++;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        int[][] nums = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue(nums));
    }

}
