/**
 * Copyright (C), 2018-2020
 * FileName: nextGreaterElements503
 * Author:   xjl
 * Date:     2020/6/12 14:27
 * Description: 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-greater-element-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode;

import org.junit.Test;

import java.util.Stack;

public class nextGreaterElements503 {

    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }

    @Test
    public void test() {
        int[] array = {-1, 0};
        int[] ints = nextGreaterElements(array);
        for (int v : ints) {
            System.out.print(v + " ");
        }
    }

}
