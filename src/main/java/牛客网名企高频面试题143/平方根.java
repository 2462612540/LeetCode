package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.平方根
 * Author:   xjl
 * Date:     2020/9/13 22:30
 * Description:
 */


import org.junit.Test;

public class 平方根 {

    public int sqrt(int x) {
        int l = 1;
        int r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x / mid > mid) {
                l = mid + 1;
            } else if (x / mid < mid) {
                r = mid - 1;
            } else if (x / mid == mid) {
                return mid;
            }
        }
        return r;//返回小的
    }

    public double squart(int x, Double pice) {
        if (x < 0) {
            return 0;
        }
        double left = 0;
        double right = x;
        double mid = 0;
        pice = pice != null ? pice : 1e-7;
        while ((right - left) > pice) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left + (right - left) / 2;
    }

    public double squart1(int x, Double pice) {
        if (x < 0) return 0;
        double left = 0;
        double right = x;
        double mid = 0;
        pice = pice != null ? pice : 0;
        while (right - left > pice) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left + (right - left) / 2;
    }

    public double squart2(int x, Double pice) {
        if (x < 0) return -1;
        double left = 0;
        double right = x;
        double mid = 0;
        pice = pice != null ? pice : 0;
        while ((right - left) > pice) {
            mid = left + (right - left) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left + (right - left) / 2;

    }

    @Test
    public void test() {
        double sqrt = squart2(10, 0.0002);
        System.out.println(sqrt);
    }
}
