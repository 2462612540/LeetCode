/**
 * Copyright (C), 2018-2020
 * FileName: arrayNesting565
 * Author:   xjl
 * Date:     2020/7/31 20:29
 * Description: 数组的嵌套
 */
package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class arrayNesting565 {
    /**
     * 可以求解，但是这是暴力的方法
     *
     * @param nums
     * @return
     */
    public static int arrayNesting(int[] nums) {
        //创建新的Hashmap中
        //存放结果
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            int index = i;
            while (true) {
                if (!set.contains(map.get(index))) {
                    set.add(map.get(index));
                    index = map.get(index);
                } else {
                    break;
                }
            }
            if (result < set.size()) {
                result = set.size();
            }
        }
        return result;
    }

    /**
     * 时间复杂度为n
     * @param nums
     * @return
     */
    public static int arrayNesting2(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {0, 2, 1};
        int i = arrayNesting(A);
        System.out.println(i);
    }
}
