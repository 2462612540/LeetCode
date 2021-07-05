package leetode每日一题;

import org.junit.Test;
import 牛客网练习题.Solution;

import javax.security.auth.callback.ConfirmationCallback;
import java.util.*;

/**
 * @Classname 错误的集合645
 * @Description TODO
 * @Date 2021/7/4 16:10
 * @Created by xjl
 */
public class 错误的集合645 {
    //超过时间了
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (list.contains(i)) {//list.contains()的函数的时间复杂度是的O(n)
                res[0] = i;
            } else {
                list.add(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!list.contains(i)) {
                res[1] = i;
            }
        }
        return res;
    }
    /**
     * @description TODO  时间复杂度就是的在的nlog(n) 如果相邻的两个元素相等，则该元素为重复的数字。 寻找丢失的数字相对复杂，可能有以下两种情况：
     *     如果丢失的数字大于 111 且小于 nnn，则一定存在相邻的两个元素的差等于 222，这两个元素之间的值即为丢失的数字；
     *     如果丢失的数字是 111 或 nnn，则需要另外判断。
     *
      * @param: nums
     * @date: 2021/7/4 22:16
     * @return: int[]
     * @author: xjl
    */
    public int[] findErrorNums2(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            } else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }
        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }

    /**
     * @description TODO  重复的数字在数组中出现 2 次，丢失的数字在数组中出现 0 次，其余的每个数字在数组中出现 1次。
     * TODO 因此可以使用哈希表记录每个元素在数组中出现的次数，然后遍历从 1 到 n的每个数字，分别找到出现 222 次和出现 000 次的数字，即为重复的数字和丢失的数字。
     * 时间复杂度O（n）
     *
     * @date: 2021/7/4 22:15
     * @return: int[]
     * @author: xjl
    */
    public int[] findErrorNums3(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }

    @Test
    public void test() {
        int[] errorNums = findErrorNums(new int[]{1, 5, 3, 2, 2, 7, 6, 4, 8, 9});
        System.out.println(errorNums[0] + "==" + errorNums[1]);
    }
}
