package leetode每日一题;

import 牛客网练习题.Solution;

/**
 * @Classname 制作m束花所需的最少天数1482
 * @Description TODO
 * @Date 2021/5/9 15:09
 * @Created by xjl
 */
public class 制作m束花所需的最少天数1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int low = Integer.MAX_VALUE, high = 0;

        int length = bloomDay.length;
        //查找的最小值的和最大的值
        for (int i = 0; i < length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while (low < high) {
            int days = (high - low) / 2 + low;
            if (canMake(bloomDay, days, m, k)) {
                high = days;
            } else {
                low = days + 1;
            }
        }
        return low;
    }

    /**
     * @description TODO
     * @param: bloomDay 花田
     * @param: days 如果是这个日期的话 能不能实现的菜罩成功
     * @param: m
     * @param: k
     * @date: 2021/5/9 16:37
     * @return: boolean
     * @author: xjl
     */
    public boolean canMake(int[] bloomDay, int days, int m, int k) {
        int bouquets = 0;
        int flowers = 0;
        int length = bloomDay.length;
        for (int i = 0; i < length && bouquets < m; i++) {
            //保证了连续性
            if (bloomDay[i] <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}
