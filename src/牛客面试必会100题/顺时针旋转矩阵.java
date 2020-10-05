/**
 * Copyright (C), 2018-2020
 * FileName: 顺时针旋转矩阵
 * Author:   xjl
 * Date:     2020/10/5 19:48
 * Description:
 */
package 牛客面试必会100题;

public class 顺时针旋转矩阵 {
    /**
     * 矩阵的顺时针旋转就是的先对角对称  然后在左右的的对称的
     *
     * @param matrix
     * @param n
     * @return
     */
    public int[][] rotateMatrix(int[][] matrix, int n) {
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
        return matrix;
    }
}
