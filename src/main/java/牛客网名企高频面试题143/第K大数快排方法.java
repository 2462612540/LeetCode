package 牛客网名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.第K大数快排方法
 * Author:   xjl
 * Date:     2020/9/13 19:37
 * Description:
 */

public class 第K大数快排方法 {
    public int findKth(int[] a, int n, int K) {
        return find(a, 0, n - 1, K);
    }

    private int find(int[] a, int low, int hi, int K) {
        int post = postfind(a, low, hi);
        if (post + 1 < K) {
            return find(a, low, post, K);
        } else if (post + 1 < K) {
            return find(a, post, hi, K);
        } else {
            return a[post];
        }
    }

    private int postfind(int[] a, int low, int hi) {
        int post = a[low];
        while (low < hi) {
            while (low < hi && a[hi] <= post) hi++;
            a[low] = a[hi];
            while (low < hi && a[low] >= post) low++;
            a[hi] = a[low];
        }
        a[low] = post;
        return post;
    }
}

class Finder {
    public static int findKth(int[] a, int n, int K) {
        return find(a, 0, n - 1, K);
    }

    //快速排序的核心思想
    public static int find(int[] a, int low, int high, int k) {
        //计算位置
        int povit = partion(a, low, high);//返回的是分界值的索引值
        if (povit + 1 > k)
            return find(a, low, povit, k);
        else if (povit + 1 < k)
            return find(a, povit + 1, high, k);
        return a[povit];
    }

    /**
     * 怎么样将大于一个数方放置在左边小于一个数放置在右边
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    public static int partion(int[] a, int low, int high) {
        int number = a[low];
        while (low < high) {
            while (low < high && a[high] <= number) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] >= number) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = number;
        return low;
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        findKth(array, array.length, 3);
    }
}

