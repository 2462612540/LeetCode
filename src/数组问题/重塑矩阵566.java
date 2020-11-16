/**
 * Copyright (C), 2018-2020
 * FileName: 重塑矩阵566
 * Author:   xjl
 * Date:     2020/11/16 21:41
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 重塑矩阵566 {
    /**
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int clow = nums.length;
        int row = nums[0].length;
        if (clow * row < r * c) {
            return nums;
        }
        /**
         * 将数据的存储在一个list 中
         */
        List<Integer> list = new ArrayList<>();
        for (int[] arr : nums) {
            for (int v : arr) {
                list.add(v);
            }
        }
        int[][] result = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = list.get(index++);
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] ints = matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4);
        for (int[] arr : ints) {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
