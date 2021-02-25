/**
 * Copyright (C), 2018-2020
 * FileName: distributeCandies
 * Author:   xjl
 * Date:     2020/4/1 9:39
 * Description: 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 */
package leetcode练习题;

import org.junit.Test;

public class distributeCandies {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int i = 1;
        while (candies>0) {
            if (candies >=i) {
                arr[(i - 1) % num_people] += i;
            } else {
                arr[(i-1) % num_people] += candies;
                break;
            }
            candies = candies - i;
            i++;
        }
        return arr;
    }

    @Test
    public void test() {
        distributeCandies(12, 3);
    }
}
