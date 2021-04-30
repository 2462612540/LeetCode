package 牛客网名企面试笔试代码复现2021;

/**
 * @Classname 打家劫舍复现
 * @Description TODO
 * @Date 2021/4/16 10:16
 * @Created by xjl
 */
public class 打家劫舍复现 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];//只有一个时候只有偷才是最大的
        dp[1] = Math.max(nums[0], nums[1]);//两个的时候是需要比较是第一个还是第二才去偷
        for (int i = 2; i < length; i++) {
            //比较如果当前偷num[i]+空了前一个dp[i-2] 或者是不偷 那就是前一个dp[i-1]
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
