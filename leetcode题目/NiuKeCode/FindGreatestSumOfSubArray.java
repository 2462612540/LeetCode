/**
 * Copyright (C), 2018-2020
 * FileName: FindGreatestSumOfSubArray
 * Author:   xjl
 * Date:     2020/5/9 13:20
 * Description: 连续的最大子数组的最大和
 */
package NiuKeCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                list.add(sum);
            }
        }
        if (list.size() <= 0) return 0;
        Collections.sort(list);
        return list.get(list.size() - 1);
    }

    @Test
    public void test() {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        FindGreatestSumOfSubArray(array);
        System.out.println(123==Integer.valueOf("123"));
    }


}
