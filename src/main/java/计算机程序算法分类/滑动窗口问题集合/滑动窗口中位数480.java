/**
 * Copyright (C), 2018-2020
 * FileName: 滑动窗口中位数480
 * Author:   xjl
 * Date:     2020/9/4 21:21
 * Description:
 */
package 计算机程序算法分类.滑动窗口问题集合;

import java.util.Collections;
import java.util.PriorityQueue;

public class 滑动窗口中位数480 {
    //使用了优先队列这样一个工具
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Collections.reverseOrder()));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            balanceHeaps();
            if (i - k + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }

                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                balanceHeaps();
            }
        }
        return result;
    }

    private void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }
}
