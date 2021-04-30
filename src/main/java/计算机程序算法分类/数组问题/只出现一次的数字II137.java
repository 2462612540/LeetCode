package 计算机程序算法分类.数组问题;

import java.util.Arrays;

/**
 * @Classname 只出现一次的数字II137
 * @Description TODO
 * @Date 2021/4/30 9:43
 * @Created by xjl
 */
public class 只出现一次的数字II137 {

    /**
     * @description TODO
     * @param: nums 时间复杂是nlog（n）
     * @date: 2021/4/30 9:50
     * @return: int
     * @author: xjl
    */
    public int singleNumber1(int[] nums) {
        if (nums.length==1){return nums[0];}
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]) {
            return nums[nums.length - 1];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
