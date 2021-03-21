package 牛客网名企高频面试题2020;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname 名企高频面试题143.转圈打印矩阵
 * @Description TODO 这个和螺旋矩阵是一样的思想
 * @Date 2020/12/7 13:37
 * @Created by xjl
 */
public class 转圈打印矩阵 {

    public int[] printMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return null;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        //表示方向 已经是设计好的
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
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] printMatrix1(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) return null;
        int cloum = matrix[0].length;
        boolean[][] vis = new boolean[row][cloum];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        //表示当前方向
        int d = 0;
        //当前方向
        int x = 0;
        int y = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < row * cloum) {
            list.add(matrix[x][y]);
            vis[x][y] = true;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < row && ny >= 0 && ny < cloum && !vis[nx][ny]) {
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
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    //默写转圈打印矩阵的 就是考虑的是一个for 或者是while 加上专项问题
    public int[] printMatrix2(int[][] matrix) {
        //验证矩阵的安全
        int row = matrix.length;
        if (row <= 0) return null;
        int cloum = matrix[0].length;
        //设置是否访问
        boolean[][] vis = new boolean[row][cloum];
        //设置四个转动的方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dist = 0;
        //设置开始的位置
        int x = 0;
        int y = 0;
        //设置返回的结果
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < row * cloum) {
            list.add(matrix[x][y]);
            vis[x][y] = true;
            int nx = x + dx[dist];
            int ny = y + dy[dist];
            //判断是否需要专项
            if (nx >= 0 && nx < row && ny >= 0 && ny < cloum && !vis[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                dist = (dist + 1) % 4;
                nx = x + dx[dist];
                ny = y + dy[dist];
                x = nx;
                y = ny;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void test() {
        int[] arr = printMatrix2(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
