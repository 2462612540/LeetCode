/**
 * Copyright (C), 2018-2020
 * FileName: 合并两个有序数组88
 * Author:   xjl
 * Date:     2020/11/2 16:35
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.Arrays;

public class 合并两个有序数组88 {
    /**
     * 最好的就是采用归并的思想来的判断数据
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int index = 0;
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] >= nums2[p2]) {
                result[index++] = nums2[p2++];
            } else {
                result[index++] = nums1[p1++];
            }
        }
        while (p1 < m) {
            result[index++] = nums1[p1++];
        }
        while (p2 < n) {
            result[index++] = nums2[p2++];
        }
        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    public void merge5(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0))
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int index = 0;
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            result[index++] = nums1[p1] > nums2[p2] ? nums2[p2++] : nums1[p1++];
        }
        while (p1 < m) {
            result[index++] = nums1[p1++];
        }
        while (p2 < n) {
            result[index++] = nums2[p2++];
        }
        for (int i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    public void merge6(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while(len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    /**
     * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，
     * 为O((n+m)log⁡(n+m))O((n + m)\log(n + m))O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

        for (int i:nums1){
            System.out.print(i+"--");
        }
    }

    @Test
    public void test() {
        merge6(new int[]{0}, 0, new int[]{1}, 1);
    }
}
