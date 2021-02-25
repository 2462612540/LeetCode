/**
 * Copyright (C), 2018-2020
 * FileName: GetNumberOfK
 * Author:   xjl
 * Date:     2020/5/9 13:27
 * Description: 统计一个数字在排序数组中出现的次数。
 */
package 牛客网练习题;

import org.junit.Test;

public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
        }

        return count;
    }

    @Test
    public void test() {
        int[] a = {3};
        int res = GetNumberOfK(a, 3);
        Math.max(1, 2);
        System.out.println(res);
    }
}
