/**
 * Copyright (C), 2018-2020
 * FileName: PrintMinNumber
 * Author:   xjl
 * Date:     2020/5/17 16:10
 * Description: 打印最小的数据
 */
package NiuKeCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintMinNumber {
    List<String> list = new ArrayList<>();
    boolean[] used;

    public void generatepermuation(String[] nums, int index, String str) {
        //递归的终止
        if (index == nums.length) {
            list.add(str);
            return;
        }
        //递归
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                str += nums[i];
                used[i] = true;
                generatepermuation(nums, index + 1, str);
                str = str.substring(0, str.length() - 1);
                used[i] = false;
            }
        }
        return;
    }

    public String PrintMinNumber(int[] numbers) {
        String[] array = new String[numbers.length];
        used = new boolean[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        generatepermuation(array, 0, "");
        for (String s : list) {
            System.out.println(s);
        }
        return "";
    }

    @Test
    public void test() {
        int[] nums = {3, 32, 321};
        PrintMinNumber1(nums);
    }

    public String PrintMinNumber1(int[] numbers) {
        String res = "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            res += list.get(i);
        }
        System.out.println(res);
        return res;
    }

}
