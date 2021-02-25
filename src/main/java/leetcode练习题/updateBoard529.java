/**
 * Copyright (C), 2018-2020
 * FileName: updateBoard529
 * Author:   xjl
 * Date:     2020/8/20 15:25
 * Description: 扫雷游戏
 */
package leetcode练习题;

public class updateBoard529 {
    int N;
    int M;
    //表示的8个方向
    int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        N = board.length;
        M = board[0].length;
        //点击的位置
        int x = click[0];
        int y = click[1];

        if (board[x][y] == 'M') {
            //如果是的雷
            board[x][y] = 'X';
        } else {
            //如果不是
            dfs(board, x, y);
        }
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        int sum = 0;
        //第一次遍历搜索
        for (int k = 0; k < 8; k++) {
            int x1 = x + dx[k];
            int y1 = y + dy[k];
            if (x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) {
                continue;
            }
            if (board[x1][y1] == 'M') {
                sum++;
            }
        }
        //判断雷的数量
        if (sum != 0) {
            board[x][y] = (char) ('0' + sum);
            return;
        }
        board[x][y] = 'B';
        //第二次遍历搜索
        for (int k = 0; k < 8; k++) {
            int x1 = x + dx[k];
            int y1 = y + dy[k];
            if (x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) {
                continue;
            }
            //如果是的E的话那就将递归
            if (board[x1][y1] == 'E') {
                dfs(board, x1, y1);
            }
        }
    }
}
