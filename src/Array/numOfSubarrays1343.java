/**
 * Copyright (C), 2018-2020
 * FileName: numOfSubarrays1343
 * Author:   xjl
 * Date:     2020/6/12 9:10
 * Description: 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 */
package Array;

import org.junit.Test;

public class numOfSubarrays1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum >= threshold * k) {
                result++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] array = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int i = numOfSubarrays(array, 3, 5);
        System.out.println(i);

    }
}
