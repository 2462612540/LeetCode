/**
 * Copyright (C), 2018-2020
 * FileName: kidsWithCandies1431
 * Author:   xjl
 * Date:     2020/6/1 16:20
 * Description: 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。  对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 */
package NewLeetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class kidsWithCandies1431 {
    public List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = Collections.max(Arrays.stream(candies).boxed().collect(Collectors.toList()));
        for (int i = 0; i < candies.length; i++) {
            if (extraCandies + candies[i] >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies);
        }
        return ret;
    }

    @Test
    public void test() {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> list = kidsWithCandies(candies, extraCandies);
        for (boolean v : list) {
            System.out.print(v+"  ");
        }
    }
}
