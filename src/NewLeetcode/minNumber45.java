/**
 * Copyright (C), 2018-2020
 * FileName: minNumber45
 * Author:   xjl
 * Date:     2020/6/3 14:44
 * Description: 面试题45. 把数组排成最小的数
 */
package NewLeetcode;

import org.junit.Test;

import java.util.Arrays;

public class minNumber45 {
    public String minNumber(int[] nums) {
        String s = "";
        //转化为字符串
        for (int i = 0; i < nums.length; i++) {
            s += String.valueOf(nums[i]);
        }
        //分别存储为数组
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        Arrays.sort(array);
        if (array[0] == 0) {
            int temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
        for (int val : array) {
            System.out.print(val + " ");
        }
        return null;
    }

    @Test
    public void test() {
        int[] array = {17,2};
        minNumber(array);
    }
}
