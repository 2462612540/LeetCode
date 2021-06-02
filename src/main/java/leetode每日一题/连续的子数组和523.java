package leetode每日一题;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 连续的子数组和523
 * @Description TODO
 * @Date 2021/6/2 10:27
 * @Created by xjl
 */
public class 连续的子数组和523 {
    /**
     * @description TODO
     * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
     * 子数组大小 至少为 2 ，且
     * 子数组元素总和为 k 的倍数
     * 如果存在，返回 true ；否则，返回 false 。
     * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
     * @param: nums
     * @param: k
     * @date: 2021/6/2 10:27
     * @return: boolean
     * @author: xjl
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        //求解的是前缀和
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int strat = 0; strat < nums.length - 1; strat++) {
            for (int end = strat + 1; end < nums.length; end++) {
                int summ = sum[end] - sum[strat] + nums[strat];
                if (summ == k || (k != 0 && summ % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @description TODO
     * 这种方法的思路是
     * 假设 sum[:i]的和为 n * k + 余数
     * 假设 sum[;j]的和为 m * k + 余数
     * <p>
     * 只要两个的余数是一致的，那么sum[j] - sum[i] 就可以被 k 整除
     * <p>
     * 最后记得一个特例[0,0] 0
     * 需要map提前处理
     * @param: nums
     * @param: k
     * @date: 2021/6/2 22:09
     * @return: boolean
     * @author: xjl
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum) && i - map.get(sum) > 1) {
                return true;
            } else if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return false;
    }

    @Test
    public void test() {
        boolean ans = checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6);
        System.out.println(ans);
    }
}
