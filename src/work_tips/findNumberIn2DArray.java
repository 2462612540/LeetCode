/**
 * Copyright (C), 2018-2020
 * FileName: findNumberIn2DArray
 * Author:   xjl
 * Date:     2020/3/5 11:55
 * Description: 二维数组的遍历
 */
package work_tips;

public class findNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] S : matrix) {
            for (int value : S) {
                if (value == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
