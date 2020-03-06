/**
 * Copyright (C), 2018-2020
 * FileName: Bubble_Test
 * Author:   xjl
 * Date:     2020/3/6 8:14
 * Description: 冒泡的测试类
 */
package JAVA_sort_arithmetic.test;

import JAVA_sort_arithmetic.src.Bubble;
import org.junit.Test;

public class Bubble_Test {
    @Test
    public void bubbleTest() {
        Integer[] nums = new Integer[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = (int) (Math.random() * 10 + 10.0);
        }
        Bubble.sort(nums);
//        for (int value : nums) {
//            System.out.println(value);
//        }
    }
}
