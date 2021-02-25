/**
 * Copyright (C), 2018-2020
 * FileName: minNumber45
 * Author:   xjl
 * Date:     2020/6/3 14:44
 * Description: 面试题45. 把数组排成最小的数
 */
package leetcode练习题;

import org.junit.Test;

import java.util.Arrays;

public class minNumber45 {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] ss = new String[nums.length];
        //数组转为的是string 类型 的数据
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        //关键是利用了排序的 重写方法  这个排序的规则的方法是一个核心
        Arrays.sort(ss, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        //String[] 数组转化为string类型
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : ss) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        int[] array = {17, 2};
        String s = minNumber(array);
        System.out.println(s);
    }
}
