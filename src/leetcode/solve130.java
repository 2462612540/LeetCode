/**
 * Copyright (C), 2018-2020
 * FileName: solve130
 * Author:   xjl
 * Date:     2020/8/11 10:33
 * Description: 130. 被围绕的区域
 */
package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class solve130 {
    int M, N;

    /**
     * 使用的是的一个逆向思维
     *
     * @param board
     */

    public void solve1(char[][] board) {
        //如果说这个不存在的话
        if (board == null || board.length == 0) {
            return;
        }
        //求解的行列
        M = board.length;
        N = board[0].length;
        //开始从四标寻找 上下行
        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);

            if (board[i][N - 1] == 'O')
                dfs(board, i, N - 1);
        }
        //左右列
        for (int j = 0; j < N; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);

            if (board[M - 1][j] == 'O')
                dfs(board, M - 1, j);
        }
        //做个一个遍历
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = board[i][j] == 'A' ? 'O' : 'x';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= M || y < 0 || y >= N || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        //四个方向
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }


    //计算的四个方向
    int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m;
    int n;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0)
            return;
        n = board[0].length;
        // 从上下左右四个边缘出发
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //表示的是最外面的0
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                //否则其他的都是的淹没了
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    /**
     * DFS 方法递归的方法
     *
     * @param board
     * @param x
     * @param y
     */
    private void dfs1(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
            return;
        board[x][y] = 'A';
        for (int i = 0; i < 4; i++)
            dfs1(board, x + d[i][0], y + d[i][1]);
    }

    /**
     * 采用的是的BFS的一个处理  常用的才做就是的队列的辅助
     * @param board
     */
    public void solve2(char[][] board) {
        m = board.length;
        if(m == 0)
            return;
        n = board[0].length;
        Deque<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O')
                queue.add(new int[]{0, i});
            if(board[m-1][i] == 'O')
                queue.add(new int[]{m-1, i});
        }
        for(int i = 1; i < m-1; i++){
            if(board[i][0] == 'O')
                queue.add(new int[]{i, 0});
            if(board[i][n-1] == 'O')
                queue.add(new int[]{i, n-1});
        }
        //BFS的关键
        while(!queue.isEmpty()){
            //取出一个来
            int[] t = queue.remove();
            board[t[0]][t[1]] = 'A';
            for(int i = 0; i < 4; i++){
                int x = t[0] + d[i][0];
                int y = t[1] + d[i][1];
                if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'){
                    //添加下一个节点
                    queue.add(new int[]{x, y});
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

}
