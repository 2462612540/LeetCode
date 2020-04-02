/**
 * Copyright (C), 2018-2020
 * FileName: massage
 * Author:   xjl
 * Date:     2020/3/24 18:28
 * Description: 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/the-masseuse-lcci 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

public class massage {
    public int massage2(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public int massage(int[] nums) {
        for (int i=nums.length;i>0;i--){
            for (int j=1;j<i;j++){
                if (nums[j]>nums[j-1]){
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                }
            }
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }

    @Test
    public void test() {
        int[] numbers = {2, 1, 4, 5, 3, 1, 1, 3};
        System.out.println(massage2(numbers));
    }
}
