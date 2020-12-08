package 名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 缺失的数字
 * @Description TODO 从0,1,2,...,n这n+1个数中选择n个数，组成有序数组，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 * @Date 2020/12/8 12:33
 * @Created by xjl
 */
public class 缺失的数字 {
    /**
     * @description TODO 使用的是遍历的数据 时间复杂度就是
     * @param: a
     * @date: 2020/12/8 13:07
     * @return: int
     * @author: xjl
     */
    public int solve(int[] a) {
        int sum = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (sum == a[i]) {
                sum += 1;
            } else {
                break;
            }
        }
        return sum;
    }

    /**
     * @description TODO 使用的是二分法的来实现
     * @param: a
     * @date: 2020/12/8 12:51
     * @return: int
     * @author: xjl
     */
    int solve3(int[] a) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            //表示除以二
            int mid = l + ((r - l) >> 1);
            if (mid == a[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l == a[l] ? l + 1 : l;
    }

    /**
     * @description TODO 使用的是位运算
     * @param: a
     * @date: 2020/12/8 13:00
     * @return: int
     * @author: xjl
     */
    public int solve2(int[] a) {
        int res = a.length;
        for (int i = 0; i < a.length; i++) {
            res ^= i ^ a[i];
            System.out.println(res);
        }
        return res;
    }

    @Test
    public void test() {
        int i = solve2(new int[]{0, 1, 2, 3, 4, 5, 7});
        System.out.println(i);
    }
}
