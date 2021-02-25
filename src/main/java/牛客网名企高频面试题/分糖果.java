package 牛客网名企高频面试题;

import java.util.Arrays;

/**
 * @Classname 分糖果
 * @Description TODO
 * @Date 2020/12/13 21:23
 * @Created by xjl
 */
public class 分糖果 {
    /**
     * @description TODO 空间复杂度是不符合要求的  时间复杂度是可以的
     * @param: arr
     * @date: 2020/12/13 21:49
     * @return: int
     * @author: xjl
     */
    public int candy(int[] arr) {
        int n = arr.length;
        int l[] = new int[n];
        int r[] = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);
        for (int i = 1; i < l.length; i++) {
            if (arr[i] > arr[i - 1])
                l[i] = l[i - 1] + 1;
        }
        for (int i = r.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1])
                r[i] = r[i + 1] + 1;
        }
        int count = 0;
        for (int i = 0; i < l.length; i++) {
            count += Math.max(l[i], r[i]);
        }
        return count;
    }

    public int candy1(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int len = arr.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);
        int total = 0;
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1])
                candies[i] = candies[i - 1] + 1;

        }
        for (int j = len - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1] && candies[j] <= candies[j + 1])
                candies[j] = candies[j + 1] + 1;
        }
        for (int i = 0; i < len; i++) {
            total += candies[i];
        }
        return total;
    }
}
