/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class 连续最大和数组 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine().trim().substring(1);
        String str = str1.substring(0, str1.length() - 1);
        String[] split = str.split(",");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            list.add(Integer.valueOf(s));
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        int result = test11(array);
        System.out.println(result);
    }

    private static int test11(int[] array) {
        if (array.length == 0 || array == null) {
            return 0;
        }
        int sum = array[0];
        int cursum = 0;
        for (int i = 0; i < array.length; i++) {
            if (cursum <= 0) {
                cursum = array[i];
            } else {
                cursum = cursum + array[i];
            }
            if (cursum > sum) {
                sum = cursum;
            }
        }
        return sum;
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (len == 0){
            return 0;
        }
        int[] currentsum = new int[len];
        currentsum[0] = array[0];
        int greatsetsum = array[0];
        for(int i=1;i<array.length;i++){
            //下面是动态规划的状态转移方程
            if(currentsum[i-1]>0){
                currentsum[i] = currentsum[i-1] + array[i];
            }else{
                currentsum[i] = array[i];
            }
            //根据currentsum的值更新greatsetsum的值
            if(currentsum[i] > greatsetsum){
                greatsetsum  = currentsum[i];
            }
        }
        return greatsetsum;
    }

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
