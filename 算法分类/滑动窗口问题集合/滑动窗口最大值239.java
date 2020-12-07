/**
 * Copyright (C), 2018-2020
 * FileName: 滑动窗口最大值239
 * Author:   xjl
 * Date:     2020/9/4 20:58
 * Description:
 */
package 滑动窗口问题集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值239 {

    @Test
    public void test() {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int[] res = maxSlidingWindow3(nums, 3);
        for (int v : res) {
            System.out.print(v + "--");
        }
    }

    /**
     * 暴力的方法 但是超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = i; j < i + k; j++) {
                list.add(nums[j]);
            }
            ans.add(Collections.max(list));
            list.clear();
        }

        int[] array = new int[ans.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = ans.get(i);
        }
        return array;
    }

    /**
     * 通过左右的遍历
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) left[i] = nums[i];  // block_start
            else left[i] = Math.max(left[i - 1], nums[i]);

            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

    /**
     * 双端队列 Deque<Integer>
     * 利用的是的单调队列
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        //顶一个双端队列 用于存储元素的下标的位置
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //当队列不为空的时候 且队列的最后一个元素小于当前元素的时候
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                //出队操作
                deque.pollLast();
            }
            //否则入队 是元素的下标
            deque.add(i);
            //不在范围内的需要删除的队列中对头  保证位置一定是小于i-k的位置
            while (!deque.isEmpty() && deque.getFirst() < i - k) {
                deque.pollFirst();
            }
            //获取队列头元素
            if (i >= k - 1) {
                result.add(nums[deque.getFirst()]);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
