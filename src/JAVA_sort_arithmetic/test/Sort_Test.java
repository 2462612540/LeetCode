/**
 * Copyright (C), 2018-2020
 * FileName: Sort_Test
 * Author:   xjl
 * Date:     2020/3/6 8:14
 * Description: 冒泡的测试类
 */
package JAVA_sort_arithmetic.test;

import JAVA_sort_arithmetic.src.base_sort.Bubble;
import JAVA_sort_arithmetic.src.base_sort.Insert;
import JAVA_sort_arithmetic.src.base_sort.Select;
import JAVA_sort_arithmetic.src.high_sort.Merge;
import JAVA_sort_arithmetic.src.high_sort.Shell;
import org.junit.Test;

import java.util.Arrays;

public class Sort_Test {
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

    @Test
    public void selectTest() {
        Integer[] nums = {4, 8, 57, 2, 68, 3, 58};
        Select.sort(nums);//这里实际上是进行了地址的传递的一个过程 所以不需要的惊醒返回的
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void InsertTest() {
        Integer[] nums = {4, 8, 57, 2, 68, 3, 58};
        Insert.sort(nums);//这里实际上是进行了地址的传递的一个过程 所以不需要的惊醒返回的
        System.out.println(Arrays.toString(nums));

    }

    @Test
    public void ShellTest() {
        Integer[] nums = {4, 8, 57, 2, 68, 3, 58};
        Shell.sort(nums);//这里实际上是进行了地址的传递的一个过程 所以不需要的惊醒返回的
        System.out.println("shell=" + Arrays.toString(nums));

    }

    @Test
    public void mergeTest() {
        Integer[] nums = {4, 8, 57, 2, 68, 3, 58};
        Merge.sort(nums);//这里实际上是进行了地址的传递的一个过程 所以不需要的惊醒返回的
        System.out.println("merge=" + Arrays.toString(nums));
    }
}
