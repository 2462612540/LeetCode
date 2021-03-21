package 牛客网名企高频面试题2020;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Classname 最小栈
 * @Description TODO
 * @Date 2020/12/17 10:51
 * @Created by xjl
 */
public class 最小栈 {

    public int[] getMinStack(int[][] op) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int[] arr : op) {
            if (arr[0] == 1) {
                if (stack.size() == 0) {
                    stack.add(arr[1]);
                    stack.add(arr[1]);
                } else {
                    Integer peek = stack.peek();
                    if (peek >= arr[1]) {
                        stack.add(peek);
                        stack.add(arr[1]);
                    } else {
                        stack.add(arr[1]);
                        stack.add(peek);
                    }
                }
            } else if (arr[0] == 2) {
                stack.pop();
                stack.pop();
            } else {
                Integer ans = stack.peek();
                list.add(ans);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void test() {
        int[] minStack = getMinStack(new int[][]{{1, 3}, {1, 2}, {1, 1}, {3}, {2}, {3}});
        for (int i : minStack) {
            System.out.print(i + " ");
        }
    }
}
