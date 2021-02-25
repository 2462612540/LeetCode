/**
 * Copyright (C), 2018-2020
 * FileName: 四个数的和
 * Author:   xjl
 * Date:     2020/9/6 9:48
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.*;

public class 四个数的和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);//排序
        int len = nums.length;
        if (nums == null || len < 4)//长度小于四，直接返回。测试用例好像没有长度小于四的，去掉也行
            return result;
        for (int i = 0; i < len - 3; ++i) {
            if (nums[i] > target / 4)//最小的数都大于target的1/4，后面的不用看了
                break;
            if (i > 0 && nums[i] == nums[i - 1])//去重
                continue;
            for (int j = i + 1; j < len - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1])//去重
                    continue;
                int low = j + 1;
                int high = len - 1;
                while (low < high) {
                    if (nums[high] < target / 4)
                        //最大的都小于targer的1/4，后面的不用看了
                        break;
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) ++low;//跳过相同的值
                        while (low < high && nums[high] == nums[high - 1]) --high;//跳过相同的值
                        ++low;
                        --high;
                    } else if (sum < target) {
                        //和小于目标值，low增大，使和增大
                        while (low < high && nums[low] == nums[low + 1]) ++low;
                        ++low;
                    } else {
                        //和大于目标值，high减小，使值减小
                        while (low < high && nums[high] == nums[high - 1]) --high;
                        --high;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        //除重复
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);//排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int p = j + 1;
                int q = nums.length - 1;
                int currentTarget = target - nums[i] - nums[j];
                while (p < q) {
                    int sum = nums[p] + nums[q];
                    if (sum == currentTarget) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[p]);
                        list.add(nums[q]);
                        set.add(list);
                        p++;
                        q--;
                    } else if (sum < currentTarget) {
                        p++;
                    } else {
                        q--;
                    }
                }
            }
        }
        for (List list : set) {
            result.add(list);
        }
        return result;
    }

    @Test
    public void test() {
        int[] A = {-3, -2, -1, 0, 0, 1, 2, 3};
        List<List<Integer>> lists = fourSum1(A, 0);
        for (List list : lists) {
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
        }

    }
}
