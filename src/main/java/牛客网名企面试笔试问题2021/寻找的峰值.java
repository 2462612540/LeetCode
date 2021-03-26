package 牛客网名企面试笔试问题2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname 寻找的峰值
 * @Description TODO
 * @Date 2021/3/26 10:42
 * @Created by xjl
 */
public class 寻找的峰值 {

    public int solve(int[] a) {
        if (a.length <= 1) {
            return -1;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length - 1; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i] && a[i] > a[i + 1]) {
                index = i;
                stack.pop();
            }
            stack.add(i);
        }
        return index;
    }

    public int solve2(int[] a) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                if (a[i] >= a[i + 1]) {
                    index = 0;
                }
            } else if (i == a.length - 1) {
                if (a[i] >= a[i - 1]) {
                    index = a.length - 1;
                }
            } else {
                if (a[i] >= a[i + 1] && a[i] >= a[i - 1]) {
                    index = i;
                }
            }
        }
        return index;
    }

    @Test
    public void test() {
        int i = solve(new int[]{2, 4, 1, 2, 7, 8, 4});
        System.out.println(i);
    }
}
