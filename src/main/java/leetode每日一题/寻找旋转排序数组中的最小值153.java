package leetode每日一题;

import org.junit.Test;
import 牛客网练习题.Solution;

/**
 * @Classname 寻找旋转排序数组中的最小值153
 * @Description TODO 时间复杂度是o(N)
 * @Date 2021/4/8 11:15
 * @Created by xjl
 */
public class 寻找旋转排序数组中的最小值153 {
    public int findMin(int[] nums) {
        int mix = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mix = mix < nums[i] ? mix : nums[i];
        }
        return mix;
    }

    /**
     * @description TODO  采用的是的二分法的来实现的
     * @param: nums
     * @date: 2021/4/8 11:26
     * @return: int
     * @author: xjl
     */
    public int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    @Test
    public void test() {
        int min = findMin(new int[]{4, 5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }
}
