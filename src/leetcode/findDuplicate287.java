/**
 * Copyright (C), 2018-2020
 * FileName: findDuplicate287
 * Author:   xjl
 * Date:     2020/5/26 8:16
 * Description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-the-duplicate-number 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode;

import org.junit.Test;

/**
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class findDuplicate287 {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return nums[j];
                }
            }
        }
        return 0;
    }

    public int findDuplicate2(int[] nums) {
        return 0;
    }

    @Test
    public void test() {
        int[] number = {1, 3, 4, 2, 2};
        findDuplicate(number);

    }
}
