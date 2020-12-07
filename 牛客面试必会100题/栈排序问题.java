package 牛客面试必会100题;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname 栈排序问题
 * @Description TODO
 * @Date 2020/12/7 10:25
 * @Created by xjl
 */
public class 栈排序问题 {
    /**
     * @description TODO 超时运行
     * @param: a
     * @date: 2020/12/7 10:55
     * @return: int[]
     * @author: xjl
     */
    public int[] solve(int[] a) {
        //判断数组安全
        if (a == null || a.length == 0) {
            return a;
        }
        int index = 0, n = a.length;
        int Max = Integer.MIN_VALUE;
        //maxarr记录的是数组中最大的值和位置
        int[][] maxarr = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > Max) {
                Max = a[i];
                index = i;
            }
            maxarr[i][0] = Max;
            maxarr[i][1] = index;
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        //入栈和注意最大的值的情况
        for (int i = 0; i < n; i++) {
            stack.push(a[i]);
            if (maxarr[i][1] == i) {
                list.add(stack.pop());
                while (!stack.isEmpty() && i < n - 1 && stack.peek() > maxarr[i + 1][0]) {
                    list.add(stack.pop());
                }
            }
        }
        //剩余的弹出
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        //将list转为数组
        int[] res = new int[a.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] solve1(int[] a) {
        //判断数组安全
        if (a == null || a.length == 0) {
            return a;
        }
        List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
        Collections.sort(list);
        int[] arr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            arr[i] = list.get(a[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int max = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            while (stack.contains(max--)) {
                res.add(a[i]);
            }
            stack.add(arr[i]);
        }
        return null;
    }

    @Test
    public void test() {
        int[] solve = solve1(new int[]{2, 1, 5, 3, 4});
        for (int i : solve) {
            System.out.print(i + " ");
        }
    }
}
