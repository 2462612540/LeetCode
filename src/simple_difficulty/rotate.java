/**
 * Copyright (C), 2018-2020
 * FileName: rotate
 * Author:   xjl
 * Date:     2020/3/3 10:47
 * Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
package simple_difficulty;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 通过k来控制好移动的次数
 */
public class rotate {
    //超出时间限制了
    public static void rotate(int[] nums, int k) {
        int temp = 0;
        for (int i = 0; i < k; i++) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
        for (int key : nums) {
            System.out.println(key);
        }
    }

    public static void rotate2(int[] nums, int k) {
        //新建立一个数组和原来一样的大小 将原来的数据直接放入其中
        int[] newnums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newnums[(i + k) % (nums.length)] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newnums[i];
        }
    }
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
    public static void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
        for (int key:nums){
            System.out.print(key+"/");
        }
    }

        public static void main (String[]args){
            int[] nums = {-1,-100,3,99};
            int k = 2;
            rotate3(nums, k);
        }
    }
