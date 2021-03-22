package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Classname 递增子序列长度
 * @Description TODO
 * @Date 2021/3/22 14:11
 * @Created by xjl
 */
public class 递增子序列长度 {

    @Test
    public void test() {
        int i = lengthOfLIS(new int[]{7,7,7,7,7,7,7});
        System.out.println("长度等于="+i);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }
}
