/**
 * Copyright (C), 2018-2020
 * FileName: 汇总区间228
 * Author:   xjl
 * Date:     2020/11/13 10:39
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 */
public class 汇总区间228 {
    /**
     * 使用的是的双指针的效果 i 指向头部 j 指向尾部 如果是的j 不但能于前面的-1 则将list.add(nums[i]+"->"+nums[j])
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 == nums.length || nums[j] + 1 != nums[j + 1]) {
                result.add(String.valueOf(nums[i]) + (i == j ? "" : "->" + String.valueOf(nums[j])));
                i = j + 1;
            }
        }
        return result;
    }

    /**
     * 采用的是的数组的遍历的+list的这样的一种形式
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length <= 0) {
            return list;
        }
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int[] arr = new int[2];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            } else {
                arr[1] = nums[i - 1];
                if (arr[0] == arr[1]) {
                    list.add(arr[0] + "");
                } else {
                    list.add(arr[0] + "->" + arr[1]);
                }
                arr[0] = nums[i];
            }
        }
        arr[1] = nums[nums.length - 1];
        if (arr[0] == arr[1]) {
            list.add(arr[0] + "");
        } else {
            list.add(arr[0] + "->" + arr[1]);
        }
        return list;
    }

    @Test
    public void test() {
        List<String> list = summaryRanges(new int[]{-2147483648, -2147483647, 2147483647});
        for (String s : list) {
            System.out.println(s);
        }
    }
}
