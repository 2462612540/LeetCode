/**
 * Copyright (C), 2018-2020
 * FileName: findContinuousSequence
 * Author:   xjl
 * Date:     2020/3/31 9:23
 * Description: 和为s的连续正数序列
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();
        while (i <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                // 左边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    @Test
    public void test(){
        for (int[] lits:findContinuousSequence(9)){
            for (int va:lits){
                System.out.print(va);
            }
            System.out.println();
        }
    }

}
