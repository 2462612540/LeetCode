/**
 * Copyright (C), 2018-2020
 * FileName: DFS
 * Author:   xjl
 * Date:     2020/7/15 20:46
 * Description: ces
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class Maintest {

    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        String[] nums = sc.nextLine().split(",");
        //函数的调用
        String maxnumbers = test(nums);
        //结果
        System.out.println(maxnumbers);
    }

    private static String test(String[] nums) {
        //存放所有数据的结果
        ArrayList<String> result = new ArrayList<>();
        //每次
        ArrayList<String> list = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        slove(nums, 0, result, list, visit);
        //获取最大值
        int max = Integer.valueOf(result.get(0));
        for(String s:result){
            max=max> Integer.valueOf(s)?max:Integer.valueOf(s);
        }
        return String.valueOf(max);
    }

    private static void slove(String[] nums, int index, ArrayList<String> result, ArrayList<String> list, boolean[] visit) {
        //终止条件
        if (index == nums.length) {
            result.add(change(list));
        } else {
            //递归的开始
            for (int i = 0; i < nums.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    list.add(nums[i]);
                    slove(nums, index + 1, result, list, visit);
                    //回溯算法
                    visit[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private static String change(ArrayList<String> list) {
        String res = "";
        for (String s : list) {
            res += s;
        }
        return res;
    }
}
