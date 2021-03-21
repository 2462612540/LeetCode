package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.螺旋矩阵II
 * Author:   xjl
 * Date:     2020/10/1 9:45
 * Description:
 */

import org.junit.Test;

public class 螺旋矩阵III {

    @Test
    public void test() {
        int[][] res = spiralMatrixIII(5, 6, 1, 4);
        for (int[] a : res) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    /**
     * 也是螺旋矩阵的思想
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int total = R * C;
        int x = r0, y = c0, d = 0;

        int[][] result = new int[R * C][2];
        boolean[][] vis = new boolean[R][C];
        int index = 0;
        int cnt = 1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        if (x >= 0 && x < R && y >= 0 && y < C) {
            result[index][0] = x;
            result[index][1] = y;
            index += 1;
            total--;
        }

        while (total > 0) {
            //表示的步长度 每一次都是一样的
            int len = (cnt - 1) / 2 + 1;
            for (int i = 1; i <= len; i++) {
                //计算一下点的坐标
                x += dx[d];
                y += dy[d];
                if (x >= 0 && x < R && y >= 0 && y < C) {
                    result[index][0] = x;
                    result[index][1] = y;
                    index += 1;
                    total--;
                }
            }
            //计算转向
            d = (d + 1) % 4;
            //并且长度加1
            cnt++;
        }
        return result;
    }
}
