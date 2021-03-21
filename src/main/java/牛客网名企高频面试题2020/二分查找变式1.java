package 牛客网名企高频面试题2020;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.二分查找变式1
 * Author:   xjl
 * Date:     2020/9/13 19:18
 * Description:
 */


public class 二分查找变式1 {

    private static int search(int n, int v, int[] a) {
        if (v > a[n - 1]) {
            return n + 1;
        }
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < v) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo + 1;
    }

    public int upper_bound_(int n, int v, int[] a) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] >= v) {
                if (mid == 0) {
                    return mid + 1;
                }
                if (a[mid - 1] < v) {
                    return mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {
                l = mid + 1;
            }
        }
        return n + 1;
    }
}
