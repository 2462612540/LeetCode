/**
 * Copyright (C), 2018-2020
 * FileName: missingNumber
 * Author:   xjl
 * Date:     2020/3/5 14:41
 * Description: 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package 牛客网练习题;

public class missingNumber {
    public static int missingNumber(int[] nums) {
        for (int i = 0; i <= nums[nums.length - 1]; i++) {
            if (i != nums[i]) {
                return i;
            }
            if(i+1==nums.length){
                return nums[i]+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] n = {0};
        System.out.println(missingNumber(n));
    }
}
