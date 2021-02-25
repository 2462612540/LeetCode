/**
 * Copyright (C), 2018-2020
 * FileName: nextGreaterElement496
 * Author:   xjl
 * Date:     2020/6/12 13:31
 * Description: 496. 下一个更大元素 I
 */
package leetcode练习题;

import org.junit.Test;

public class nextGreaterElement496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    //开始进入number2中找接下来的最大值
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            result[i] = nums2[k];
                            break;
                        } else {
                            continue;
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 0) {
                result[i] = -1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        int[] ints = nextGreaterElement(num1, num2);
        for (int v : ints) {
            System.out.print(v + " ");
        }
    }
}
