/**
 * Copyright (C), 2018-2020
 * FileName: 移动零283
 * Author:   xjl
 * Date:     2020/10/23 9:49
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.ArrayList;

public class 移动零283 {

    @Test
    public void test6() {
        moveZeroes6(new int[]{0, 1, 0, 3, 12});
    }

    /**
     * 一次遍历的就可以实现
     *
     * @param nums
     */
    public void moveZeroes6(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //进行元素交换
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    @Test
    public void test4() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    /**
     * 默写的一遍 时间复杂度为o(n)+o(m)表示的0的个数
     *
     * @param nums
     */
    public void moveZeroes5(int[] nums) {
        int a = 0;
        //将不是0的全部放置子新的数组上
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[a++] = nums[i];
            }
        }
        for (int i = a; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    /**
     * 通过使用的是的两次遍历 第一次的将将不是0的元素放置在前面  遍历完成所有的元素后在来重第一次后的遍历并将元素设置为0
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void test3() {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
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
