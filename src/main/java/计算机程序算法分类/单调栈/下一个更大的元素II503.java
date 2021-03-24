package 计算机程序算法分类.单调栈;

import org.junit.Test;

import java.util.*;

/**
 * @Classname 下一个更大的元素503
 * @Description TODO
 * @Date 2021/3/24 10:06
 * @Created by xjl
 */
public class 下一个更大的元素II503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Stack<Integer> stack = new Stack<>();
        //遍历的长度为2n-1
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            //单调栈中的存储的是的位数组的位置
            stack.push(i % n);
        }
        return ret;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 1};
        int[] result = nextGreaterElements(nums1);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
