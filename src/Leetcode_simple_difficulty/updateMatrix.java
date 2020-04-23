/**
 * Copyright (C), 2018-2020
 * FileName: updateMatrix
 * Author:   xjl
 * Date:     2020/4/20 9:22
 * Description: DFS
 */
package Leetcode_simple_difficulty;

import java.util.LinkedList;
import java.util.Queue;

public class updateMatrix {

    public int[][] updateMatrix(int[][] matrix) {
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return matrix;
    }

    public int[][] updateMatrix2(int[][] matrix) {
        //如果是空的话那就返回为null
        if (matrix == null || matrix.length == 0) return null;
        //矩阵的行列的数据
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];//结果集
        boolean[][] visited = new boolean[m][n];//记录已经计算过的位置
        Queue<int[]> queue = new LinkedList<>();//广搜队列
        //遍历，将等于0的位置计入结果集并入队
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                    //如果为0 那么就需要时设置为ture 其他的就是flase
                    visited[i][j] = true;
                    //两者都是往队列尾部插入元素，不同的时候，当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
                    //入队的操作是将0的位置放入到队列中
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //四个方向广搜
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右
        while (!queue.isEmpty()) {
            //Queue 中 remove() 和 poll()都是用来从队列头部删除一个元素。在队列元素为空的情况下，remove() 方法会抛出NoSuchElementException异常，poll() 方法只会返回 null 。
            int[] poll = queue.poll();
            //获取到队列的数据的行列数据 i表示行数据 j表示列的数据
            int i = poll[0], j = poll[1];
            //四个方向上找1
            for (int k = 0; k < 4; k++) {
                int di = i + direction[k][0], dj = j + direction[k][1];
                //没有计算过的地方一定是1
                if (di >= 0 && di < m && dj >= 0 && dj < n && !visited[di][dj]) {
                    res[di][dj] = res[i][j] + 1;
                    visited[di][dj] = true;
                    queue.offer(new int[]{di, dj});
                }
            }
        }
        return res;
    }
}
