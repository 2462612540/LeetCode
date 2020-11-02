/**
 * Copyright (C), 2018-2020
 * FileName: orangesRotting994
 * Author:   xjl
 * Date:     2020/8/11 14:33
 * Description: 994. 腐烂的橘子
 */
package leetcode;

import java.util.*;

public class orangesRotting994 {

    public int orangesRotting(int[][] grid) {
        Queue<Integer> queue = new LinkedList();
        int M = grid.length;//行
        int N = grid[0].length;//列
        //判断是否有腐烂的橘子
        boolean hasrottn = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                //判断将有腐败橘子的放入队列中
                if (grid[i][j] == 2) {
                    queue.add(i * N + j);
                    //表示有的烂橘子
                    hasrottn = true;
                }
            }
        }
        //用于控制坐标的
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int min = 0;
        while (!queue.isEmpty()) {
            //统计多少的长度
            int len = queue.size();
            //有多少的全部踢出来
            for (int i = 0; i < len; i++) {
                int curr = queue.remove();
                int x = curr / N;
                int y = curr % N;
                //去腐烂四周的
                for (int k = 0; k < 4; k++) {
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    //判断是否越界 不能让新的值越界
                    if (xx >= 0 && xx < M && yy < N && yy >= 0 && grid[xx][yy] == 1) {
                        //感染橘子
                        grid[xx][yy] = 2;
                        queue.add(xx * N + yy);
                    }
                }
            }
            min++;
        }
        //检测是否还有新鲜的橘子在里面 如果有的化那么不能完成任务
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return hasrottn ? min - 1 : 0;
    }

    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};

    /**
     * 多源广度优先搜索
     *
     * @param grid
     * @return
     */
    public int orangesRotting1(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
        int ans = 0;

        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    //腐烂
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        //检测是否还有新鲜的橘子在里面 如果有的化那么不能完成任务
        for (int[] row : grid)
            for (int v : row)
                if (v == 1)
                    return -1;
        return ans;
    }

    int grid[][];
    int r;
    int l;

    public int orangesRotting2(int[][] grid) {
        if (grid.length == 0)
            return -1;
        this.r = grid.length;
        this.l = grid[0].length;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {      //烂橘子开始传染病毒
                    dps(i, j, 2);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;            //有新鲜的橘子
                max = Math.max(grid[i][j], max);  //找到需要最多时间腐烂的橘子
            }
        }
        return max > 0 ? max - 2 : max;
    }

    public void dps(int i, int j, int val) {
        //表示的四烂橘子
        grid[i][j] = val;
        //判断周围是新鲜的橘子或者是烂得更慢的橘子
        if (i > 0 && (grid[i - 1][j] == 1 || grid[i - 1][j] - grid[i][j] > 1)) {
            dps(i - 1, j, 1 + val);
        }
        if (j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] - grid[i][j] > 1)) {
            dps(i, j - 1, 1 + val);
        }
        if (i < r - 1 && (grid[i + 1][j] == 1 || grid[i + 1][j] - grid[i][j] > 1)) {
            dps(i + 1, j, 1 + val);
        }
        if (j < l - 1 && (grid[i][j + 1] == 1 || grid[i][j + 1] - grid[i][j] > 1)) {
            dps(i, j + 1, 1 + val);
        }
    }
}
