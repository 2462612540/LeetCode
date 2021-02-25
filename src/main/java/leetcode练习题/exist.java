/**
 * Copyright (C), 2018-2020
 * FileName: exist
 * Author:   xjl
 * Date:     2020/4/24 8:48
 * Description: 回溯算法的二维平面
 */
package leetcode练习题;

import org.junit.Test;

public class exist {
    //四个方向
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    boolean[][] visit = new boolean[m][n];

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        //赋值没有访问过
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }
        //开始遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchword(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchword(char[][] board, String word, int index, int startx, int starty) {
        //递归的终止条件
        if (index == word.length() - 1) {
            return board[startx][starty] == word.charAt(index);
        }
        //递归的流程
        if (board[startx][starty] == word.charAt(index)) {
            visit[startx][starty] = true;
            //从四个方向开始往下寻找
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visit[newx][newy]) {
                    if (searchword(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            visit[startx][starty] = false;
        }
        return false;
    }

    //判断是否在矩阵中
    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }

    @Test
    public void test() {

    }
}
