/**
 * Copyright (C), 2018-2020
 * FileName: sqrt
 * Author:   xjl
 * Date:     2020/3/1 12:56
 * Description: 计算平方更
 */
package leetcode练习题;

/**
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 */
public class sqrt {
    public static int mySqrt(int x) {
        double low = 0, high = x, middle, squre;
        while ( high - low > 1e-7 ) {
            middle = ( low + high ) / 2;
            squre = middle * middle;
            if ( squre > x ) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (int)( low + high ) / 2;
    }
    public static int mySqrt2(int x){
        int ans = -1;
        if (0 == x){
            return 0;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int x=8;
        System.out.println(mySqrt2(x));
    }
}
