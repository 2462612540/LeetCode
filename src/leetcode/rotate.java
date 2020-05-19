/**
 * Copyright (C), 2018-2020
 * FileName: rotate
 * Author:   xjl
 * Date:     2020/3/28 10:13
 * Description: 将图像顺时针旋转 90 度。
 */
package leetcode;

import org.junit.Test;

public class rotate {
    /**
     * 求解矩阵的旋转是：通过对角线的变换 2 然后在行交换既可以
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        //获取矩阵的大小
        int row = matrix.length;
        int columns = matrix[0].length;
        //对角元素的交换
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //列数交换
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][columns - j - 1];
                matrix[i][columns - j - 1] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13,3,6,7},{15,14,12,16}};
//        System.out.println(matrix.length);//获取行数
//        System.out.println(matrix[0].length);//获取的是列数
        rotate(matrix);
    }
}
