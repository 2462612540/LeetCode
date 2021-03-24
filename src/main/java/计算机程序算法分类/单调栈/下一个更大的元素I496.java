package 计算机程序算法分类.单调栈;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @Classname 下一个更大的元素I496
 * @Description TODO
 * @Date 2021/3/24 10:14
 * @Created by xjl
 */
public class 下一个更大的元素I496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[nums2.length - 1], -1);

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.add(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.peek(), -1);
            stack.pop();
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums1 = {3,6,1};
        int[] nums2 = {1,3,4,2,5,6};

        int[] ints = nextGreaterElement(nums1, nums2);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
