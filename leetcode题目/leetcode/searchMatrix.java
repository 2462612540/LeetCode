/**
 * Copyright (C), 2018-2020
 * FileName: searchMatrix
 * Author:   xjl
 * Date:     2020/3/4 14:34
 * Description: 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 */
package leetcode;

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] is : matrix) {
            for (int i : is) {
                if (i == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
