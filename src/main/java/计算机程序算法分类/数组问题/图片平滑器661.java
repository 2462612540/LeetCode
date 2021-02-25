/**
 * Copyright (C), 2018-2020
 * FileName: 图片平滑器661
 * Author:   xjl
 * Date:     2020/11/17 9:54
 * Description:
 */
package 计算机程序算法分类.数组问题;

public class 图片平滑器661 {
    int row = 0;
    int col = 0;
    // 上、下、左、右，上左，上右，下左，下右 八个方向
    int dirR[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    int dirC[] = {0, 0, -1, 1, -1, 1, -1, 1};

    /**
     * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
     * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr)
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }

    public int[][] imageSmoother2(int[][] M) {
        if (M == null || M.length < 1 || M[0] == null || M[0].length < 1) {
            return null;
        }
        row = M.length;
        col = M[row - 1].length;
        int ans[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[i][j] = calcul(M, i, j);
            }
        }
        return ans;
    }

    private int calcul(int arr[][], int i, int j) {
        int count = 1;
        int sum = arr[i][j];
        for (int k = 0; k < dirR.length; k++) {
            int nextR = i + dirR[k];
            int nextC = j + dirC[k];
            //判断的是的新的数据是否在矩阵中  如果在矩阵中的话 那就表示的是的可以加入
            if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) {
                count++;
                sum += arr[nextR][nextC];
            }
        }
        return sum / count;
    }
}
