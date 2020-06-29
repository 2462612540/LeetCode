/**
 * Copyright (C), 2018-2020
 * FileName: findKthLargest215
 * Author:   xjl
 * Date:     2020/3/4 14:39
 * Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 */
package NiuKeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
            }
        }
        return list.get(list.size() - k);

    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }
}
