/**
 * Copyright (C), 2018-2020
 * FileName: 距离顺序排列矩阵单元格1030
 * Author:   xjl
 * Date:     2020/11/17 8:52
 * Description:
 */
package 计算机程序算法分类.每日一题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 * <p>
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（
 * <p>
 * 你可以按任何满足此条件的顺序返回答案。）
 */
public class 距离顺序排列矩阵单元格1030 {

    /**
     * 本解法可以使用哈希表优化，即使用坐标作 key，使用距离作 value，然后按照距离排序，这样就不会因为多次对同一下标进行比较而重复计算距离
     * 无论如何优化，核心仍然是直接排序，时间复杂度不会优于 O(R*C*log(R*C))
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int t = i * C + j;
                re[t][0] = i;
                re[t][1] = j;
            }
        }
        Arrays.sort(re, (arr1, arr2) -> {
            int d1 = dist(arr1[0], arr1[1], r0, c0);
            int d2 = dist(arr2[0], arr2[1], r0, c0);
            return Integer.compare(d1, d2);
        });

        return re;
    }

    private int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    /**
     * 最容易想到的方法是首先存储矩阵内所有的点，然后将其按照哈曼顿距离直接排序。
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                ret[i * C + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });
        return ret;
    }

    /**
     * 采用的是BFS方法
     * 可以把所有的坐标看作树的结点，距离相等的结点位于树的同一层
     * 而对于每一层的结点，它们的距离 dist 可以分为行距离和列距离，且 rowDist + colDist = dist 必然成立
     * 使 rowDist 从 0 到 dist 递增，colDist 相应有不同的值，可以得到不同的坐标：
     * 横坐标为：r0 - rowDist 或 r0 + rowDist
     * 纵坐标为：c0 - colDist 或 c0 + colDist
     * 注意特殊情况：rowDist 或 colDist 为 0 时，每组只有一个正确值
     * 对步骤 3 中，所有在矩阵范围内的坐标进行记录
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] re = new int[R * C][2];
        int dist = 0;
        int cnt = 0;
        int[] factor = {-1, 1};
        while (cnt < R * C) {
            for (int rowDist = 0; rowDist <= dist; rowDist++) {
                int colDist = dist - rowDist;
                for (int i = 0; i < 2; i++) {
                    int row = r0 + factor[i] * rowDist;
                    for (int j = 0; j < 2; j++) {
                        int col = c0 + factor[j] * colDist;
                        if (row >= 0 && row < R && col >= 0 && col < C) {
                            re[cnt][0] = row;
                            re[cnt][1] = col;
                            cnt++;
                        }
                        if (colDist == 0) break;
                    }
                    if (rowDist == 0) break;
                }
            }
            dist++;
        }
        return re;
    }
}
