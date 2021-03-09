package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Classname 单调栈
 * @Description TODO
 * @Date 2021/3/9 10:20
 * @Created by xjl
 */
public class 单调栈 {
    /**
     * @description TODO  采用最简单的方式 暴力破解的方法
     * @param: nums
     * @date: 2021/3/9 10:35
     * @return: int[][]
     * @author: xjl
     */
    public int[][] foundMonotoneStack(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[][] arr = new int[nums.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = -1;
            arr[i][1] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    arr[i][0] = j;
                    break;
                }
            }

            for (int k = i + 1; k < nums.length; k++) {
                if (nums[i] > nums[k]) {
                    arr[i][1] = k;
                    break;
                }
            }
        }
        return arr;
    }

    public int[][] foundMonotoneStack2(int[] nums) {
        // write code here
        Stack<ArrayList<Integer>> stack = new Stack<>();
        int[][] result = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek().get(0)]) {
                ArrayList<Integer> pop = stack.pop();
                int l = stack.isEmpty() ? -1 : stack.peek().get(0);
                int r = i;
                for (Integer index : pop) {
                    result[index][0] = l;
                    result[index][1] = r;
                }
            }
            if (!stack.isEmpty() && stack.peek().get(0).equals(nums[i])) {
                stack.peek().add(i);
            } else {
                ArrayList<Integer> ele = new ArrayList<>();
                ele.add(i);
                stack.push(ele);
            }
        }
        //出栈的问题
        while (!stack.isEmpty()) {
            ArrayList<Integer> pop = stack.pop();
            int l = stack.isEmpty() ? -1 : stack.peek().get(0);
            int r = -1;
            for (Integer index : pop) {
                result[index][0] = l;
                result[index][1] = r;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[][] ints = foundMonotoneStack2(new int[]{3, 4, 1, 5, 6, 2, 7});
        for (int[] arr : ints) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
