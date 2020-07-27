/**
 * Copyright (C), 2018-2020
 * FileName: exist
 * Author:   xjl
 * Date:     2020/7/16 10:50
 * Description: 79. 单词搜索
 */
package DFS_BFS;

/**
 * 这个是最常见的动态规划的解释
 */
public class exist {

    //四个方向
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n;
    //定义的是否访问的数组的
    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        //初始化的是的时候就是false
        visit = new boolean[m][n];
        //开始遍历每一个数字
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
        //判断是否为字符串中的数
        if (board[startx][starty] == word.charAt(index)) {
            visit[startx][starty] = true;
            //从四个方向开始往下寻找
            for (int i = 0; i < 4; i++) {
                //开始的计算新的x和y的位置
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                //判断是否超出范围和是否访问过了
                if (inArea(newx, newy) && !visit[newx][newy]) {
                    //进行递归的下去
                    if (searchword(board, word, index + 1, newx, newy)) {
                        return true;
                    }
                }
            }
            //进行回溯的
            visit[startx][starty] = false;
        }
        return false;
    }

    //判断是否在矩阵中
    private boolean inArea(int newx, int newy) {
        return newx >= 0 && newx < m && newy >= 0 && newy < n;
    }
}
