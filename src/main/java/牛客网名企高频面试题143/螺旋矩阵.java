package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.螺旋矩阵
 * Author:   xjl
 * Date:     2020/10/1 9:19
 * Description:
 */

import org.junit.Test;

import java.util.ArrayList;

public class 螺旋矩阵 {

    @Test
    public void test() {
        ArrayList<Integer> list = spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(list);
    }

    /**
     * 名企高频面试题143.螺旋矩阵 使用的就是模拟的思想
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        //表示方向 已经是 设计好的
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        //表示的是起始位置
        int x = 0;
        int y = 0;
        //表示转向的标志
        int d = 0;
        //存放结果
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < m * n) {
            list.add(matrix[x][y]);
            vis[x][y] = true;
            int nx = x + dx[d];
            int ny = y + dy[d];
            //表示的是可以开始方向
            if (nx < m && nx >= 0 && ny < n && ny >= 0 && !vis[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
                x = nx;
                y = ny;
            }
        }
        return list;
    }


    public ArrayList<Integer> spiralOrder2(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] vis = new boolean[m][n];
        int d = 0;
        int x = 0;
        int y = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < m * n) {
            list.add(matrix[x][y]);
            vis[x][y] = true;
            //下一个位置
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
                x = nx;
                y = ny;
            }
        }
        return list;
    }
}
