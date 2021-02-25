package 牛客网名企高频面试题;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二分查找的算法
 * Author:   xjl
 * Date:     2020/9/13 18:21
 * Description:
 */


public class 二分查找的算法 {
    /**
     * 单纯的二分查找能力
     *
     * @param target
     * @param array
     * @return
     */
    private static int bin_search(int target, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }
}
