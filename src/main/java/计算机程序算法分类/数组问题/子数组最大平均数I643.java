/**
 * Copyright (C), 2018-2020
 * FileName: 子数组最大平均数I643
 * Author:   xjl
 * Date:     2020/11/16 22:27
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class 子数组最大平均数I643 {
    /**
     * 第一种是利用数组的遍历
     * 采用list  sum result  遍历依次就可以实现
     * 其实 就是求解的连续k的最大和位多少就好 可以使用的的是动态的规划的问题 遍历一个就够了 不需要维护一个数组或者是队列
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        double sum = 0;
        ArrayList<Integer> list = new ArrayList<>();//保留着的原来数组 也是采用的是双端度列的
        for (int i = 0; i < nums.length; ) {
            while (list.size() < k) {
                sum += nums[i];
                list.add(nums[i++]);
            }
            result = result > (sum / k) ? result : (sum / k);
            sum -= list.get(0);
            list.remove((Object) list.get(0));
        }
        return result;
    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage1(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }

    @Test
    public void test() {
        double maxAverage = findMaxAverage(new int[]{-1}, 1);
    }
}
