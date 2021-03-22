package 牛客网名企面试笔试问题2021;

import org.junit.Test;

/**
 * @Classname NC155牛牛的数列
 * @Description TODO
 * @Date 2021/3/22 16:03
 * @Created by xjl
 */
public class NC155牛牛的数列 {

    @Test
    public void test() {
        int i = maxSubArrayLength(new int[]{7, 2, 3, 1, 5, 6});
        System.out.println(i);
    }

    /**
     * @description TODO 牛牛现在有一个n个数组成的数列,牛牛现在想取一个连续的子序列,并且这个子序列还必须得满足:最多只改变一个数,就可以使得这个连续的子序列是一个严格上升的子序列,牛牛想知道这个连续子序列最长的长度是多少。
     * @param: nums
     * @date: 2021/3/22 16:04
     * @return: int
     * @author: xjl
     */
    public static int maxSubArrayLength(int[] nums) {
        // write code here
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int res = 0;
        int len = nums.length;
        int[] left = new int[len];  //用于存储每个元素结尾的最长上升子序列长度
        int[] right = new int[len];//用于存储每个元素开始的最长上升子序列长度
        //设置在两头的数据
        left[0] = 1;
        right[len - 1] = 1;
        //最左向右 找出 连续的子序列
        for (int i = 1; i < len; i++) {
            left[i] = nums[i] > nums[i - 1] ? left[i - 1] + 1 : 1;
        }
        //从右向左 找出 连续的子系列
        for (int i = len - 2; i >= 0; i--) {
            right[i] = nums[i] < nums[i + 1] ? right[i + 1] + 1 : 1;
        }
        //最终结果
        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] < nums[i + 1]) {
                res = Math.max(res, left[i - 1] + right[i + 1] + 1);
            }
        }
        return res;
    }
}
