package 牛客网名企面试笔试问题2021;

import org.junit.Test;

/**
 * @Classname 数组的旋转
 * @Description TODO
 * @Date 2021/3/26 13:36
 * @Created by xjl
 */
public class 数组的旋转 {
    //交换的数组
    public void swap(int[] array, int n, int m) {
        while (n < m) {
            array[n] = array[m] + array[n];
            array[m] = array[n] - array[m];
            array[n] = array[n] - array[m];
            n++;
            m--;
        }
    }

    public int[] solve(int n, int m, int[] a) {
        if (a.length <= 1) {
            return a;
        }
        m=m%n;
        swap(a, 0, n - 1);
        swap(a, 0, m - 1);
        swap(a, m, n - 1);
        return a;
    }

    @Test
    public void test() {
        int[] solve = solve(6, 7, new int[]{1, 2, 3, 4, 5, 6});
        for (int i : solve) {
            System.out.print(i + " ");
        }
    }
}
