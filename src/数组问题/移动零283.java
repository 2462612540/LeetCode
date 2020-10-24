/**
 * Copyright (C), 2018-2020
 * FileName: 移动零283
 * Author:   xjl
 * Date:     2020/10/23 9:49
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.util.ArrayList;

public class 移动零283 {

    /**
     * 通过使用的是的两次遍历
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {

    }

    /**
     * 采用的是的双指针的进行移动
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        int index1 = 0;//记录0的位置
        int index2 = 0;//记录不是0的位置
        while (index2 < nums.length) {
            if (nums[index2] == 0) {
                if (nums[index1] != 0) {
                    index1 = index2;
                }
                index2++;
            } else {
                if (nums[index1] == 0) {
                    //交换元素
                    int tmp = nums[index1];
                    nums[index1] = nums[index2];
                    nums[index2] = tmp;
                }
                index1++;
                index2++;
            }
        }
    }

    @Test
    public void test() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    /**
     * 采用的是的一个数组
     *
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            } else {
                count++;
            }
        }
        while (count > 0) {
            list.add(0);
            count--;
        }
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test1() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

}
