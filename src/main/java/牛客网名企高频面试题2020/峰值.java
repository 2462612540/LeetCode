package 牛客网名企高频面试题2020;

import org.junit.Test;

/**
 * @Classname 峰值
 * @Description TODO  山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
 * 假设 nums[-1] = nums[n] = -∞。
 * @Date 2020/12/8 19:23
 * @Created by xjl
 */
public class 峰值 {

    @Test
    public void test() {
        int solve = solve(new int[]{2, 4, 1, 2, 7, 8, 4});
        System.out.println(solve);
    }

    public int solve(int[] a) {
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
}
