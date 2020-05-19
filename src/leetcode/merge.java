/**
 * Copyright (C), 2018-2020
 * FileName: merge
 * Author:   xjl
 * Date:     2020/3/1 14:22
 * Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 */
package leetcode;

/**
 * 第一步是将数据和并到第一个中
 * 在利用冒泡排序进行排序
 */
public class merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp=0;
        for(int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        //利用排序的算法在进行排序
        for(int i=0;i<m+n;i++){
            for(int j=0;j<i;j++){
                if(nums1[i]<nums1[j]){
                    temp=nums1[j];
                    nums1[j]=nums1[i];
                    nums1[i]=temp;
                }
            }
        }
        for (int key:nums1){
            System.out.println(key);
        }
    }
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3,n=3;
        merge(nums1,m,nums2,n);
    }
}
