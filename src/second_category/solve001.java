/**
 * Copyright (C), 2018-2020
 * FileName: solve001
 * Author:   xjl
 * Date:     2020/7/8 9:13
 * Description: 题目描述 牛牛最近搬到了一座新的城镇，这个城镇可以看成是一个一维的坐标系。城镇上有n个居民，第i个居民的位置为aia_iai​。现在牛牛有m个搬家方案，在第i个方案中他会搬到位置xix_ixi​。  俗话说的好，远亲不如近邻。现在牛牛想知道，对于每个搬家方案，搬家后与最近的居民的距离为多少。
 */
package second_category;

import org.junit.Test;

public class solve001 {
    //通过率只有80%

    /**
     * 远亲不如近邻
     *
     * @param n int整型 居民个数
     * @param m int整型 方案个数
     * @param a int整型一维数组 居民的位置
     * @param x int整型一维数组 方案对应的位置
     * @return int整型一维数组
     */
    public int[] solve2(int n, int m, int[] a, int[] x) {
        //返回的结果
        int[] result = new int[m];
        //遍历两次的x的数据 每一个在数组中最小的元素
        for (int i = 0; i < m; i++) {
            int min = Math.abs(x[i] - a[0]);
            for (int j = 0; j < n; j++) {
                int res = Math.abs(x[i] - a[j]);
                min = min < res ? min : res;
            }
            result[i] = min;
        }
        return result;
    }

    public int[] solve(int n, int m, int[] a, int[] x) {
        //返回的结果
        int[] result = new int[m];
        //遍历两次的x的数据 每一个在数组中最小的元素
        for (int i = 0; i < m; i++) {
            int min = Math.abs(x[i]);
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int x1 = Math.abs(x[i] - a[start]);
                int y1 = Math.abs(x[i] - a[end]);
                min = Math.min(min, Math.min(x1, y1));
                start++;
                end--;
            }
            result[i] = min;
        }
        return result;
    }

    @Test
    public void test() {
        int[] a = {2,4,7};
        int[] x = {5,8};
        int[] solve = solve(3, 2, a, x);
        for (int i = 0; i < solve.length; i++) {
            System.out.println(solve[i]);
        }
    }
}
