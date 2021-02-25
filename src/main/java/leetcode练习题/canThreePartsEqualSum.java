/**
 * Copyright (C), 2018-2020
 * FileName: canThreePartsEqualSum
 * Author:   xjl
 * Date:     2020/4/1 9:20
 * Description: 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false
 */
package leetcode练习题;

import org.junit.Test;

public class canThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        // 总和不是3的倍数，直接返回false
        if (sum % 3 != 0) {
            return false;
        }
        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];
        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while (left + 1 < right) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if (leftSum != sum / 3) {
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if (rightSum != sum / 3) {
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }

    @Test
    public void test() {

    }
}
