/**
 * Copyright (C), 2018-2020
 * FileName: findMedianSortedArrays4
 * Author:   xjl
 * Date:     2020/8/24 21:09
 * Description:
 */
package Array;

public class findMedianSortedArrays4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //保证数组永远是的nums2是长的那个数组
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;//短的数组
        int n = nums2.length;//长的数组

        //分割线左右两边的所需要的满足的个数
        int totalleft = (m + n + 1) / 2;
        //在numns中的找到恰当的分割线[o,m]
        //使得nums1[i-1] <=nums2[j] && nums2[j-1]<=nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            //短得数组的中位数
            int i = left + (right - left + 1) / 2;
            //长的数组的中的位置
            int j = totalleft - i;
            //保证的是的i位置左边的元素的一定是小于的是的 j的元素的 如果是大于的话 那就将i重新计算位置
            if (nums1[i - 1] > nums2[j]) {
                //搜索下一轮的区间是 [left i-1]
                right = i - 1;
            } else {
                //下一轮的搜索区间是 [i,right]  如果是大于的话那就是的计算的位置是的(i --right)
                left = i;
            }
        }
//        while (left < right) {
//            //短得数组的中位数
//            int i = left + (right - left) / 2;
//            //长的数组的中的位置
//            int j = totalleft - i;
//            //保证的是的j-1位置的元素的一大于i的元素的 如果是大于的话 那就将i重新计算位置
//            if (nums2[j - 1] > nums1[i]) {
//                //搜索下一轮的区间是 [i+1 right]
//                left = i + 1;
//            } else {
//                //下一轮的搜索区间是 [left,i]
//                right = i;
//            }
//        }
        //防止下标的越界的情况
        int i = left;
        int j = totalleft - i;
        int nums1leftmax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1Rightmin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2leftmax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2Rightmin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 1) {
            return Math.max(nums1leftmax, nums2leftmax);
        } else {
            return (double) (Math.max(nums1leftmax, nums2leftmax) + Math.min(nums1Rightmin, nums2Rightmin)) / 2;
        }
    }
}
