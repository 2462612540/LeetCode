package 牛客网名企高频面试题2020;

import org.junit.Test;

/**
 * @Classname 子数组的最大乘积和
 * @Description TODO
 * @Date 2020/12/13 22:18
 * @Created by xjl
 */
public class 子数组的最大乘积和 {

    @Test
    public void test() {
        double res = maxProduct(new double[]{0.1, 0.0, 3.0, -2.0, 0.9, -1.3, 5.0, -4.4});
        System.out.println(res);
    }

    private double maxProduct(double[] arr) {
        /**
         动态规划
         类似最大子序和
         不过需要考虑负数的问题：因为一个负数乘以一个负数可能会变为最大
         */
        double min = arr[0];
        double max = min;
        double res = min; //注意：max记录的不是最终的最大值，而是途中每一个选择的最大值，于是需要重新用一个值保存全局最大值。
        for (int i = 1; i < arr.length; i++) {
            double t_max = max;
            //最大值可以从哪些地方产生：
            // 1. arr[i]  2. min*arr[i]  3.max*arr[i]
            max = Math.max(Math.max(arr[i], arr[i] * max), min * arr[i]);
            //最小值可以从哪些地方产生：
            // 1. arr[i]  2.max*arr[i] 3.min*arr[i]
            min = Math.min(Math.min(arr[i], arr[i] * min), t_max * arr[i]);
            res = Math.max(res, max); //更新全局最大值
        }
        return res;
    }
}
