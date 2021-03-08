package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Classname 矩阵顺时针
 * @Description TODO
 * @Date 2020/12/8 10:30
 * @Created by xjl
 */
public class 矩阵顺时针 {

    @Test
    public void test() {
        int[] arr = printMartix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}});
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public int[] printMartix(int[][] martix) {
        //判断矩阵的安全
        int row = martix.length;
        if (row <= 0) return null;
        int colum = martix[0].length;
        //定义原来的方向
        boolean[][] vis = new boolean[row][colum];
        //定义方向
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dis = 0;
        //定义初始位置
        int x = 0;
        int y = 0;
        //定义返回结果
        ArrayList<Integer> list = new ArrayList<>();
        while (list.size() < row * colum) {
            list.add(martix[x][y]);
            vis[x][y] = true;
            int nx = x + dx[dis];
            int ny = y + dy[dis];
            if (nx >= 0 && nx < row && ny >= 0 && ny < colum && !vis[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                dis = (dis + 1) % 4;
                nx = x + dx[dis];
                ny = y + dy[dis];
                x = nx;
                y = ny;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
