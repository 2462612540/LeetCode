/**
 * Copyright (C), 2018-2020
 * FileName: canPlaceFlowers
 * Author:   xjl
 * Date:     2020/3/28 11:12
 * Description: 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

public class canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    @Test
    public void test() {
        int[] flowerbed = {};
        int n = 1;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
