package 名企高频面试题143;

import java.util.Arrays;

/**
 * @Classname 矩阵查找
 * @Description TODO
 * @Date 2020/12/16 10:57
 * @Created by xjl
 */
public class 矩阵查找 {
    /**
     * @description TODO 主要是的使用的二分查找的算法
     * @param: matrix
     * @param: target
     * @date: 2020/12/16 11:02
     * @return: boolean
     * @author: xjl
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        for (int[] arr : matrix) {
            //采用的是的数组的二分查找
            int index = Arrays.binarySearch(arr, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }
}
