package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.容器盛水II
 * Author:   xjl
 * Date:     2020/9/30 22:28
 * Description:
 */


import org.junit.Test;

public class 容器盛水II {

    @Test
    public void test() {
        long l = maxWater(new int[]{3, 1, 2, 5, 2, 4});
        System.out.println(l);
    }

    public long maxWater(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        long ans = 0;
        int l = 0;
        int r = arr.length - 1;

        int lmax = arr[0];
        int rmax = arr[arr.length - 1];

        while (l <= r) {
            lmax = Math.max(arr[l], lmax);
            rmax = Math.max(arr[r], rmax);
            if (lmax < rmax) {
                ans += lmax - arr[l];
                l++;
            } else {
                ans += rmax - arr[r];
                r--;
            }
        }
        return (long) ans;
    }
}
